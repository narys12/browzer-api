package com.naris.browzerapi.services;

import com.naris.browzerapi.domain.Image;
import com.naris.browzerapi.domain.Location;
import com.naris.browzerapi.domain.Picture;
import com.naris.browzerapi.repository.PictureRepository;
import com.naris.browzerapi.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public List<Picture> getPicturesByMemoryId(String memoryId) {
        return pictureRepository.findByMemoryId(memoryId);
    }

    public ResponseUtils delete(String pictureId) {
        this.pictureRepository.delete(pictureId);
        return ResponseUtils.buildDeletedResponse();
    }

    public Picture findOne(String pictureId) {
        return pictureRepository.findOne(pictureId);
    }

    public ResponseUtils countPicturesByMemory(String memoryId) {
        Long pictures = pictureRepository.countByMemoryId(memoryId);
        return ResponseUtils
                .buildCustomResponse("count", String.valueOf(pictures));
    }

    public Picture savePicture(String memoryId, Image image, Location location) {
        Picture picture = new Picture();
        picture.setImage(image);
        picture.setLocation(location);
        picture.setMemoryId(memoryId);
        return pictureRepository.save(picture);
    }


}
