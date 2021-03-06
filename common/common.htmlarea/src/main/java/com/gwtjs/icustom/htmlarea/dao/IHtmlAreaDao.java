package com.gwtjs.icustom.htmlarea.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;

/**
 * 富文本 dao
 * @author aGuang
 *
 */
@Mapper @Named("htmlAreaDao")
public interface IHtmlAreaDao {
	
	/**
	 * 保存或修改  merge动作
	 * @param sys
	 * @return
	 */
	public int saveOrUpdate(List<HtmlAreaVO> sys);
	
	/**
	 * 查询所有,没有过滤条件
	 * @return
	 */
	public List<HtmlAreaVO> findAll();
	
	/**
	 * 查询特定富文本  htmlAreaId
	 * @return
	 */
	public HtmlAreaVO findHtmlArea(@Param("htmlAreaId") Integer htmlAreaId);
	
	/**
	 * 查询特定富文本  mappingUrl
	 * @return
	 */
	public HtmlAreaVO findHtmlAreaByMappingUrl(@Param("mappingUrl") String mappingUrl);
	
	/**
	 * 查询名称,模糊查询
	 * @return
	 */
	public PagedResult<HtmlAreaVO> findHtmlAreaPage(@Param("vo") HtmlAreaVO vo,@Param("page") PageVO page);
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	int batchRemovePks(List<HtmlAreaVO> records);
	
	
	/**
	* 查询单个HtmlArea
	* @param queryHtmlArea
	* @return
	*/
	public HtmlAreaVO findHtmlArea(HtmlAreaVO queryHtmlArea);

	/**
	* 通过ID查找
	* @param queryHtmlArea
	* @return
	*/
	public HtmlAreaVO findHtmlAreaById(HtmlAreaVO newHtmlArea);
	/**
	* 通过Category和Name查找
	* @param HtmlArea
	* @return
	*/
	public HtmlAreaVO findHtmlAreaByCategoryAndName(HtmlAreaVO newHtmlArea);
	/**
	* 查询富文本的content来定制首页
	* @return
	*/
	public String findHtmlAreaContent(HtmlAreaVO queryHtmlArea);
	/**
	* 查询富文本的content来定制首页
	* @return
	*/
	public HtmlAreaVO findHtmlAreaByUrl(HtmlAreaVO queryHtmlArea);
	
}
