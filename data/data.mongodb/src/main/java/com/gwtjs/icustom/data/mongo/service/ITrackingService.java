package com.gwtjs.icustom.data.mongo.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gwtjs.icustom.data.mongo.entity.ResultWrapper;
import com.gwtjs.icustom.data.mongo.entity.TrackVO;

/**
 * 学习跟踪服务接口
 * @author aGuang
 *
 */
@Path("/record")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)
public interface ITrackingService {
	
	/**
	*
	* 课程学习启动接口，获取课程章节学习状态信息<br/>
	*
	* @param resId
	* @return
	*/
	@GET
	@Path("/launch")
	public ResultWrapper launch(@QueryParam("resId") String resId);

	/**
	* 播放初始化数据接口
	*
	* @param resId
	* @param itemId
	* @param driverType
	* @return
	*/
	@POST
	@Path("/initialize")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultWrapper initialize(TrackVO trackVO);

	/**
	* 元素读取数据接口
	*
	* @param resId
	* @param itemId
	* @param attempId
	* @param element
	* @return
	*/
	@POST
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultWrapper getValue(TrackVO trackVO);

	/**
	* 元素值更新数据接口
	*
	* @param resId
	* @param itemId
	* @param attempId
	* @param element
	* @param value
	*/
	@POST
	@Path("/set")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultWrapper setValue(TrackVO trackVO);
	
}
