package com.naris.browzerapi.services;

import com.naris.browzerapi.domain.Image;
import com.naris.browzerapi.domain.Location;
import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.repository.MemoryRepository;
import com.naris.browzerapi.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class MemoryService {

    private MemoryRepository memoryRepository;

    private PictureService pictureService;

    @Autowired
    public MemoryService(MemoryRepository memoryRepository, PictureService pictureService) {
        this.memoryRepository = memoryRepository;
        this.pictureService = pictureService;
    }

    public Memory findOne(String id) {
        return Observable
                .just(id)
                .map(memoryRepository::findOne)
                .toBlocking()
                .first();
    }

    public List<Memory> getMemories(int page, int count) {
        return Observable
                .just(new PageRequest(page, count))
                .map(memoryRepository::findAll)
                .map(Page::getContent)
                .toBlocking()
                .first();
    }

    public ResponseUtils delete(String id) {
        return Observable
                .just(id)
                .doOnNext(pictureService::deleteByMemoryId)
                .doOnNext(memoryRepository::delete)
                .map(ResponseUtils::buildDeletedResponse)
                .toBlocking()
                .first();
    }

    public Memory createOrUpdate(Memory memory, Image image, Location location) {
        return Observable
                .just(memory)
                .map(m -> m.withLocation(location))
                .map(m -> m.withImage(image))
                .map(memoryRepository::save)
                .toBlocking()
                .first();
    }
}
