package com.gwtjs.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gwtjs.springsecurity.entity.SysRole;

@Repository
public interface SysRoleDao extends JpaRepository<SysRole, Integer>{
	
	@Query("select r from SysRole r")
	List<SysRole> findAll();
	
	@Query("select r from SysRole r WHERE r.name=:name")
	SysRole findByRoleName(@Param("name") String name);
	
}
