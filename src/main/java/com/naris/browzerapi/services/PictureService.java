package com.naris.browzerapi.services;

import com.naris.browzerapi.domain.Image;
import com.naris.browzerapi.domain.Location;
import com.naris.browzerapi.domain.Memory;
import com.naris.browzerapi.domain.Picture;
import com.naris.browzerapi.global.StaticValues;
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
        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setAttribute(StaticValues.ITEM_DELETED);
        responseUtils.setValue("true");
        return responseUtils;
    }

    public Picture findOne(String pictureId) {
        return pictureRepository.findOne(pictureId);
    }

    public Picture savePicture(String src, String alt, String memoryId, String place, String country) {
        Location location = new Location();
        location.setPlace(place);
        location.setCountry(country);

        Image image = new Image();
        image.setAlt(alt);
        image.setSrc(src);

        Picture picture = new Picture();
        picture.setLocation(location);
        picture.setMemoryId(memoryId);
        picture.setImage(image);

        return pictureRepository.save(picture);
    }

    public ResponseUtils countPicturesByMemory(String memoryId) {
        Long pictures = pictureRepository.countByMemoryId(memoryId);
        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setAttribute("count");
        responseUtils.setValue(String.valueOf(pictures));
        return responseUtils;
    }

    public Picture savePicture(String memoryId, Image image, Location location) {
        Picture picture = new Picture();
        picture.setImage(image);
        picture.setLocation(location);
        picture.setMemoryId(memoryId);
        return pictureRepository.save(picture);
    }
}
