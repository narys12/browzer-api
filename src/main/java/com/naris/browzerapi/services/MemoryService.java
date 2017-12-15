package com.naris.browzerapi.services;

import com.naris.browzerapi.domain.Location;
import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.global.StaticValues;
import com.naris.browzerapi.repository.MemoryRepository;
import com.naris.browzerapi.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return this.memoryRepository.findOne(id);
    }

    public List<Memory> getMemories(int page, int count) {
        Pageable pageable = new PageRequest(page, count);
        return memoryRepository.findAll(pageable).getContent();
    }

    public ResponseUtils delete(String id) {
        this.memoryRepository.delete(id);
        this.pictureService.getPicturesByMemoryId(id)
            .stream()
            .forEach(picture -> this.pictureService.delete(id));

        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setValue("true");
        responseUtils.setAttribute(StaticValues.ITEM_DELETED);
        return responseUtils;
    }

    public Memory createOrUpdate(Memory memory, Location location) {
        memory.setLocation(location);
        return memoryRepository.save(memory);
    }
}
