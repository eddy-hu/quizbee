package com.demo.quizbee.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quizbee.web.dto.UserDTO;




@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserDTO, Long> {

	UserDTO findByEmail(String email);
	
}