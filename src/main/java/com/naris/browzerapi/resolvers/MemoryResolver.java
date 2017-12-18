package com.naris.browzerapi.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.naris.browzerapi.domain.Image;
import com.naris.browzerapi.domain.Location;
import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.domain.Picture;
import com.naris.browzerapi.services.MemoryService;
import com.naris.browzerapi.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private MemoryService memoryService;

    @Autowired
    public MemoryResolver(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    /**
     * Queries
     */

    public Memory memory(String id) {
        return memoryService.findOne(id);
    }

    public List<Memory> memories(int page, int count) {
        return memoryService.getMemories(page, count);
    }

    /**
     * Mutations
     */

    public Memory saveMemory(Memory memory, Image image, Location location) {
        return memoryService.createOrUpdate(memory, image, location);
    }

    public ResponseUtils deleteMemory(String id) {
        return memoryService.delete(id);
    }

}
