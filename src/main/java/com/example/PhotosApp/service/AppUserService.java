package com.example.PhotosApp.service;

import com.example.PhotosApp.model.AppUser;
import com.example.PhotosApp.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AppUserService {

    private final UserRepository userRepository;

    public AppUserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


}
