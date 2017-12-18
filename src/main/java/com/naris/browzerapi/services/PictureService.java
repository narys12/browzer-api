package com.naris.browzerapi.services;

import com.naris.browzerapi.domain.Image;
import com.naris.browzerapi.domain.Location;
import com.naris.browzerapi.domain.Picture;
import com.naris.browzerapi.repository.PictureRepository;
import com.naris.browzerapi.utils.DateUtils;
import com.naris.browzerapi.utils.ResponseUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public List<Picture> getPicturesByMemoryId(String memoryId) {
        return pictureRepository.findByMemoryId(memoryId);
    }

    public ResponseUtils delete(String pictureId) {
        return Observable
                .just(pictureId)
                .doOnNext(pictureRepository::delete)
                .map(ResponseUtils::buildDeletedResponse)
                .toBlocking()
                .first();
    }

    public Picture findOne(String pictureId) {
        return Observable
                .just(pictureId)
                .map(pictureRepository::findOne)
                .toBlocking()
                .first();
    }

    public ResponseUtils countPicturesByMemory(String memoryId) {
        return Observable
                .just(memoryId)
                .map(pictureRepository::countByMemoryId)
                .map(count -> ResponseUtils
                        .buildCustomResponse(String.valueOf(count), "count"))
                .toBlocking()
                .first();
    }

    public Picture savePicture(String memoryId, Image image, Location location) {
        return Observable
                .just(new Picture()
                        .withImage(image)
                        .withLocation(location)
                        .withMemoryId(memoryId)
                        .withCreatedAt(DateUtils.strMillis(DateTime.now())))
                .map(pictureRepository::save)
                .toBlocking()
                .first();
    }


    public String deleteByMemoryId(String memoryId) {
        return Observable
                .just(memoryId)
                .map(pictureRepository::deletePictureByMemoryId)
                .map(count -> memoryId)
                .toBlocking()
                .first();
    }
}
