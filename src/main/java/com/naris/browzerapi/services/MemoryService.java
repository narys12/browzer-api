package com.naris.browzerapi.services;

import com.google.common.collect.Lists;
import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.global.Variables;
import com.naris.browzerapi.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.naris.browzerapi.global.Variables.MEMORY_PAGE_SIZE;

@Service
public class MemoryService {

    @Autowired
    private MemoryRepository memoryRepository;

    @Autowired
    private PictureService pictureService;

    public Memory create(Memory memory) {
        return this.memoryRepository.save(memory);
    }

    public Memory findOne(String id) {
        return this.memoryRepository.findOne(id);
    }

    public Memory updatePicturesCount(String memoryId) {
        long picturesCount = this.pictureService.countPicturesByMemory(memoryId);
        Memory memory = this.findOne(memoryId);
        memory.setPicturesCount(picturesCount);
        return memoryRepository.save(memory);
    }

    public List<Memory> getMemories(int page) {
        Pageable pageable = new PageRequest(page, MEMORY_PAGE_SIZE);
        return memoryRepository.findAll(pageable).getContent();
    }

    public Memory update(Memory memory) {
        return this.memoryRepository.save(memory);
    }

    public void delete(Memory memory) {
        String memoryId = memory.getId();
        this.memoryRepository.delete(memoryId);
        this.pictureService.getPicturesByMemoryId(memoryId)
            .stream()
            .forEach(picture -> this.pictureService.delete(memory.getId()));
    }
}
