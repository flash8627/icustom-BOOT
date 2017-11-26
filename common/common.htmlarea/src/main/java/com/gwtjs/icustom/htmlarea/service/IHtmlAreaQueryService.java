package com.gwtjs.icustom.htmlarea.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.omg.CORBA.portable.ApplicationException;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;

@Path("/query")
@Produces("application/json")
public interface IHtmlAreaQueryService {
	/**
	 *
	 * @param category
	 * @return
	 * @throws ApplicationException
	 */
	@GET
	@Path("/list/{category}")
	public List<HtmlAreaVO> findHtmlAreaListByCategory(@PathParam("category") String category)
			throws ApplicationException;

	/**
	 * 根据Category和HtmlAreaName获取HtmlArea
	 * 
	 * @param catalog
	 * @param htmlAreaName
	 * @return
	 * @throws ApplicationException
	 */
	@GET
	@Path("/list/{category}/{name}")
	public HtmlAreaVO findHtmlAreaByCategoryAndName(@PathParam("category") String category,
			@PathParam("name") String name) throws ApplicationException;

	public HtmlAreaVO findHtmlAreaByCategoryAndName(String category, String name, boolean allowNull)
			throws ApplicationException;

	/**
	 * 根据HtmlAreaId获取HtmlArea
	 * 
	 * @param htmlAreaId
	 * @return
	 * @throws ApplicationException
	 */
	@GET
	@Path("/single/{htmlAreaId}")
	public HtmlAreaVO findHtmlAreaById(@PathParam("htmlAreaId") int htmlAreaId) throws ApplicationException;

	/**
	 * 根据name查询富文本的content来定制首页
	 * 
	 * @param name
	 * @return
	 * @throws ApplicationException
	 */
	@GET
	@Path("/content/{name}")
	@Produces("text/html")
	public String findHtmlAreaContent(@PathParam("name") String name) throws ApplicationException;

	/**
	 * 根据BindUrl查询富文本区内容，不存在时返回NULL
	 * 
	 * @param url
	 * @return
	 * @throws ApplicationException
	 */
	public HtmlAreaVO findHtmlAreaContentByUrl(@PathParam("url") String url);

	/**
	 * 用于富文本维度的查询
	 * 
	 * @param htmlAreaId
	 * @return
	 * @throws ApplicationException
	 */
	@GET
	@Path("/list/HtmlAreaDimension/page/{pageSize}/{curPage}")
	public PagedResult<Object> findHtmlAreaDimension(@QueryParam("") Object registryVO,
			@PathParam("") PageVO page) throws ApplicationException;

	/**
	 * 用于富文件维度多选查询
	 * 
	 * @param htmlAreaId
	 * @return
	 * @throws ApplicationException
	 */
	@POST
	@Path("/list/HtmlAreaDimension")
	public List<Object> findHtmlAreaDimensionByMultiValue(List<String> values) throws ApplicationException;

	/**
	 * 根据多个条件对象返回list数据
	 * 
	 * @param htmlAreaVOs
	 * @return
	 */
	@GET
	@Path("/lists")
	public List<HtmlAreaVO> findHtmlAreaListByVONames(@QueryParam("") HtmlAreaVO htmlAreaVO)
			throws ApplicationException;
}
