package com.gwtjs.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gwtjs.springsecurity.entity.SysUser;

@Repository("sysUserDao")
public interface SysUserDao extends JpaRepository<SysUser, Integer> {

	@Query("select u from SysUser u where u.name=:name")
	SysUser findByName(@Param("name") String name);

	SysUser findByEmailAndPassword(String email, String password);

	SysUser findUserByEmail(String email);

	@Modifying
	@Query("update SysUser u set u.name = ?1, u.email = ?2, u.password = ?3 where u.id = ?4")
	int update(String name, String email, String password, Integer id);

}
