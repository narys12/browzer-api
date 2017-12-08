package com.naris.browzerapi.services;

import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
