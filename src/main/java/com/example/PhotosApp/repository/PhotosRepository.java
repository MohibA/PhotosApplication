package com.example.PhotosApp.repository;

import com.example.PhotosApp.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {
}
