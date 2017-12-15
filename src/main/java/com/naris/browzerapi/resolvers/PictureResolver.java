package com.naris.browzerapi.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.naris.browzerapi.domain.Image;
import com.naris.browzerapi.domain.Location;
import com.naris.browzerapi.domain.Picture;
import com.naris.browzerapi.services.PictureService;
import com.naris.browzerapi.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PictureResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private PictureService pictureService;

    @Autowired
    public PictureResolver(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    /**
     * Queries
     */

    public List<Picture> pictures(String memoryId) {
        return pictureService.getPicturesByMemoryId(memoryId);
    }

    public Picture picture(String pictureId) {
        return pictureService.findOne(pictureId);
    }

    /**
     * Mutation
     */

    public Picture savePicture(String memoryId, Image image, Location location) {
        return pictureService.savePicture(memoryId, image, location);
    }

    public ResponseUtils deletePicture(String pictureId) {
        return pictureService.delete(pictureId);
    }

    public ResponseUtils countPicturesByMemory(String memoryId) {
        return pictureService.countPicturesByMemory(memoryId);
    }
}
