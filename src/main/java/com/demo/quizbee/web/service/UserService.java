package com.demo.quizbee.web.service;

import com.demo.quizbee.web.dto.UserDTO;

public interface UserService {
	public UserDTO findUserByEmail(String email);
	public void saveUser(UserDTO user);
}
