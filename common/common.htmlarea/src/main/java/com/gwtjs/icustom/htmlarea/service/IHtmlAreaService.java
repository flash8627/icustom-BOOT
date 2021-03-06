package com.gwtjs.icustom.htmlarea.service;

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

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/htmlAreaService") 
public interface IHtmlAreaService {
	
	/**
	 * 保存或修改  merge动作
	 * @param HtmlAreaVO
	 * @return
	 */
	@POST @Path("/saveOrUpdate")
	public ResultWrapper saveOrUpdate(HtmlAreaVO vo);
	
	/**
	 * 保存或修改  merge动作
	 * @param HtmlAreaVO
	 * @return
	 */
	@POST @Path("/batchSaveOrUpdate")
	public ResultWrapper batchSaveOrUpdate(List<HtmlAreaVO> list);
	
	/**
	 * 查询所有,没有过滤条件
	 * @return
	 */
	@GET
	@Path("/findAll")
	public List<HtmlAreaVO> findAll();
	
	/**
	 * 查询特定富文本  htmlAreaId
	 * @return
	 */
	@GET
	@Path("/findByHtmlArea/{htmlAreaId}")
	public HtmlAreaVO findHtmlArea(@PathParam("htmlAreaId") Integer htmlAreaId);
	
	/**
	 * 查询特定富文本  mappingUrl
	 * @return
	 */
	@GET
	@Path("/findHtmlAreaByMappingUrl/{mappingUrl}")
	public HtmlAreaVO findHtmlAreaByMappingUrl(@PathParam("mappingUrl") String mappingUrl);
	
	/**
	 * 查询名称,模糊查询
	 * @return
	 */
	@GET
	@Path("/findHtmlAreaPage/{pageSize}/{curPage}")
	public PagedResult<HtmlAreaVO> findHtmlAreaPage(@QueryParam("") HtmlAreaVO vo,@PathParam("") PageVO page);
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	@PUT @Path("/batchRemovePks")
	ResultWrapper batchRemovePks(List<HtmlAreaVO> records);

}
