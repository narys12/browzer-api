package com.naris.browzerapi.controllers;

import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.services.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/memory")
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping("list")
    private Memory getMemories() {
        return new Memory();
    }

    @RequestMapping("create")
    private Memory saveMemory() {
        Memory memory = new Memory();
        memory.setTitle("Memory from France");
        return memoryService.create(memory);
    }

    @RequestMapping("{id}")
    private Memory getMemory(@PathVariable String id) {
        return this.memoryService.findOne(id);
    }
}
