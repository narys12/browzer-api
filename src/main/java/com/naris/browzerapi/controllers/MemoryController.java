package com.naris.browzerapi.controllers;

import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.services.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memory")
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping("list/{page}")
    private List<Memory> getMemories(@PathVariable int page) {
        return this.memoryService.getMemories(page);
    }

    @RequestMapping(method = RequestMethod.POST)
    private Memory createMemory(@RequestBody Memory memory) {
        return memoryService.create(memory);
    }

    @RequestMapping(method = RequestMethod.PUT)
    private Memory updateMemory(@RequestBody Memory memory) {
        return memoryService.update(memory);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    private void deleteMemory(@RequestBody Memory memory) {
        memoryService.delete(memory);
    }

    @RequestMapping("{id}")
    private Memory getMemory(@PathVariable String id) {
        return this.memoryService.findOne(id);
    }
}
