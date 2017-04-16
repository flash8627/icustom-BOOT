package com.gwtjs.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gwtjs.springsecurity.entity.SysResourceRole;

@Repository("sysResourceRoleDao")
public interface SysResourceRoleDao extends
		JpaRepository<SysResourceRole, Integer> {

	/*
	 * @Query(
	 * "select u from SysUser u where u.email=:email and u.password=:password")
	 * SysUser login(@Param("email")String email, @Param("password")String
	 * password);
	 */

	/*@Query(value = "SELECT res.resource_String FROM Sys_Resource_Role srr,Sys_Resource res, Sys_Role sr WHERE sr.id=srr.role_Id AND srr.resource_Id = res.id  AND  sr.NAME =?1", nativeQuery = true)
	List<Map<String, Object>> findByName(@Param("name") String name);*/
	
	@Query(value = "SELECT srr FROM SysResourceRole srr WHERE srr.roleId=:roleId")
	List<SysResourceRole> findByRoleResource(@Param("roleId") String roleId);

}
