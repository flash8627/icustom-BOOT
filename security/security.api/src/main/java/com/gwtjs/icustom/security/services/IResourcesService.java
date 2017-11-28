package com.gwtjs.icustom.security.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;

/**
 * 系统资源  系统导航
 * @author aGuang
 *
 */
@Path("/resourcesService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IResourcesService {
	
	@GET @Path("findResourcesSiteMenu")
	List<SysResourceVO> findResourcesSiteMenu();
	
	@GET @Path("findResourcesGridTree")
	List<SysResourceVO> findResourcesGridTree();
	
	@GET @Path("findResourcesGridTree/{parentId}")
	List<SysResourceVO> findResourcesGridTree(@PathParam("parentId")long parentId);
	
	@GET @Path("findResourcesList")
	List<SysResourceVO> findResourcesList();
	
	@GET @Path("findResourcesList/{resourceId}")
	List<SysResourceVO> findResourcesList(SysResourceVO record);
	
	@GET @Path("findResources/{resourceId}")
    SysResourceVO selectByPrimaryKey(@PathParam("resourceId")long resourceId);
	
	@GET @Path("findResourcesPrimaryId")
	Integer selectByItemId();
	
	@POST @Path("batchInsert")
	ResultWrapper batchInsert(List<SysResourceVO> list);
	
	@POST @Path("insert")
	ResultWrapper insert(SysResourceVO record);

	@DELETE @Path("batchRemove")
	ResultWrapper batchRemoveResourcesPks(List<SysResourceVO> list);
	
	@DELETE @Path("deleteBy/{resourceId}")
	ResultWrapper deleteByPrimaryKey(@PathParam("resourceId")long resourceId);
	
	@POST @Path("updateByKey")
	ResultWrapper updateByPrimaryKey(SysResourceVO record);

}
