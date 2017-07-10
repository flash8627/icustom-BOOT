package com.gwtjs.icustom.register.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.icustom.register.entity.RegisterVO;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
@Path("/registerService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IRegisterService {
	
	@GET
	@Path("/findRecords/{pageSize}/{curPage}")
	public PagedResult<RegisterVO> findRecords(@QueryParam("") RegisterVO record, @PathParam("")PageVO page);
	
	@GET
	@Path("/findItem/{regId}")
	ResultWrapper findItem(@PathParam("regId")Integer regId);
	
	@GET
	@Path("/findRegisterList/{parentId}")
	List<RegisterVO> findRegisterList(@PathParam("") RegisterVO record);

	@PUT
	@Path("batchRemovePks")
	ResultWrapper batchRemovePks(List<RegisterVO> records);

	@PUT
	@Path("batchUpdate")
	ResultWrapper batchUpdate(List<RegisterVO> records);

	@POST
	@Path("batchInsert")
	ResultWrapper batchInsert(List<RegisterVO> records);

}
