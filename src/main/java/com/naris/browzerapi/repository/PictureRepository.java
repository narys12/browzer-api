package com.naris.browzerapi.repository;

import com.naris.browzerapi.domain.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PictureRepository extends MongoRepository<Picture, String> {

    long countByMemoryId(String memoryId);
    Picture findByMemoryId(String memoryId);

}
