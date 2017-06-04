package com.ege.springtemps.springsecurity.service;

import java.util.List;

import com.ege.springtemps.springsecurity.model.UserProfile;

public interface UserProfileService {


    UserProfile findById(int id);
    
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
}
