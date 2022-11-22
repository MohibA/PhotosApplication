package com.example.PhotosApp.service;


import com.example.PhotosApp.model.Photo;
import com.example.PhotosApp.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhotosService {

    private final PhotosRepository photosRepository;

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }


    public Iterable<Photo> getPhotos() {

        return photosRepository.findAll();
    }
    public Photo getPhotoById(Integer id) {
        return photosRepository.findById(id).orElse(null);
        
    }

    public Photo addPhoto(String fileName, String contentType, byte[] data)  {

        Photo photo = new Photo();
        photo.setContentType(contentType);
        //photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        //System.out.println(Arrays.toString(photo.getData()));
        return photo;

    }
    public void delete(Integer id) {
        photosRepository.deleteById(id);

    }
}
