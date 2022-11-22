package com.example.PhotosApp.web;

import com.example.PhotosApp.model.Photo;
import com.example.PhotosApp.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/")
public class PhotosController {
    private final PhotosService photosService;

    public PhotosController(PhotosService photosService) {

        this.photosService = photosService;
    }


    @GetMapping("/photos")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Iterable<Photo> getPhotos(){

        return photosService.getPhotos();
    }

    //path variable tells spring boot if you have in mapping some parameter with curly brace ID and some method parameter
    // with just put whatever is in curly brace to method param.
    @GetMapping("/photos/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public  Photo getPhotoById(@PathVariable Integer id){
        Photo photo =  photosService.getPhotoById(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void delete(@PathVariable Integer id){

        photosService.delete(id);

        if(getPhotoById(id) == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    //@RequestPart tells us which part contains the file. If you go to front end you can see the key "data" in formatData
    @PostMapping("/photos")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.addPhoto(file.getOriginalFilename(), file.getContentType(), file.getBytes());

    }


}
