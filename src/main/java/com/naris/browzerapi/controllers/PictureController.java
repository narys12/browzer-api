package com.naris.browzerapi.controllers;

import com.google.common.collect.Lists;
import com.naris.browzerapi.domain.Picture;
import com.naris.browzerapi.services.MemoryService;
import com.naris.browzerapi.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @Autowired
    MemoryService memoryService;

    @RequestMapping("save/{mId}")
    private void savePictures(@PathVariable String mId, @RequestBody Picture picture) {
        this.pictureService.savePictures(mId, Lists.newArrayList(picture));
        this.memoryService.updatePicturesCount(mId);
    }
}
