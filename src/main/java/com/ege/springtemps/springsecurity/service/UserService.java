package com.ege.springtemps.springsecurity.service;


import java.util.List;

import com.ege.springtemps.springsecurity.model.User;

public interface UserService {
	User findBySSO(String ssoId);

	List<User> findAllUsers();

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserBySSO(String ssoId);

	User findById(int id);

	boolean isUserSSOUnique(Integer id, String sso);
}
