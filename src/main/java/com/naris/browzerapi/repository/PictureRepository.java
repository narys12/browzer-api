package com.naris.browzerapi.repository;

import com.naris.browzerapi.domain.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PictureRepository extends MongoRepository<Picture, String> {

    long countByMemoryId(String memoryId);
    List<Picture> findByMemoryId(String memoryId);
    long deletePictureByMemoryId(String memoryId);

}
