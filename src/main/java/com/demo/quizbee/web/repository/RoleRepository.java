package com.demo.quizbee.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quizbee.web.dto.RoleDTO;





@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleDTO, Long>{

	RoleDTO findByType(String type);


}
