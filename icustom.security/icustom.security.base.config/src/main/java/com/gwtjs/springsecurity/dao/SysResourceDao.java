package com.gwtjs.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gwtjs.springsecurity.entity.SysResource;
import com.gwtjs.springsecurity.entity.SysUser;

@Repository("sysResourceDao")
public interface SysResourceDao extends JpaRepository<SysResource, Integer> {

	@Query("select u from SysResource u where u.resourceName=:resourceName")
	SysUser findByName(@Param("resourceName") String resourceName);

	@Query("select sr from SysResource sr where sr.id in(:ids)")
	List<SysResource> findByRoleName(@Param("ids") List<Integer> ids);
	
	@Query("select sr from SysResource sr where sr.resourceString=:url")
	List<SysResource> findByResourceString(@Param("url") String url);

}
