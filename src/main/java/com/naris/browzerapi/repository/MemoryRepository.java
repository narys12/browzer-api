package com.naris.browzerapi.repository;

import com.naris.browzerapi.domain.Memory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemoryRepository extends MongoRepository<Memory, String> {
}
