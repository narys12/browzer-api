package com.naris.browzerapi.services;

import com.naris.browzerapi.domain.Picture;
import com.naris.browzerapi.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public long countPicturesByMemory(String memoryId) {
        return pictureRepository.countByMemoryId(memoryId);
    }

    public void savePictures(String memoryId, List<Picture> pictures) {
        pictures
                .stream()
                .forEach(picture -> {
                    picture.setMemoryId(memoryId);
                    this.pictureRepository.save(picture);
                });
    }
}
