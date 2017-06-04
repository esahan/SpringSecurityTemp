package com.ege.springtemps.springsecurity.dao;

import java.util.List;

import com.ege.springtemps.springsecurity.model.UserProfile;

public interface UserProfileDao {
	
    List<UserProfile> findAll();
    
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}
