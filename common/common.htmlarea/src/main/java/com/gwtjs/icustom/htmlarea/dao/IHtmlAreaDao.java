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
	
	/**new add */
	/**
	* 创建HtmlArea
	* @param vo
	*/
	public int createHtmlArea(HtmlAreaVO vo) ;
	/**
	* 更新HtmlArea
	* @param vo
	*/
	public int updateHtmlArea(HtmlAreaVO vo) ;
	/**
	* 删除HtmlArea
	* @param vo
	*/
	public int deleteHtmlArea(HtmlAreaVO vo) ;
	/**
	* 查询单个HtmlArea
	* @param queryHtmlArea
	* @return
	*/
	public HtmlAreaVO findHtmlArea(HtmlAreaVO queryHtmlArea);
	/**
	* 分页查找HtmlArea
	* @param queryHtmlArea
	* @return
	*/
	public List<HtmlAreaVO> findHtmlAreaList(HtmlAreaVO queryHtmlArea);
	/**
	* 查找HtmlAreaList
	* @param queryHtmlArea
	* @param pageVO
	* @return
	*/
	public PagedResult<HtmlAreaVO> findPagedHtmlAreaList(HtmlAreaVO queryHtmlArea,PageVO pageVO);

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
	/**
	* 批量删除HtmlArea
	* @param vo
	*/
	public int deleteHtmlAreaList(List<HtmlAreaVO> htmlAreaVO);

	/**
	* export导出数据查询
	* @param queryHtmlArea
	* @param pageVO
	*/
	public PagedResult<HtmlAreaVO> findExportHtmlAreaList(HtmlAreaVO queryHtmlArea,PageVO pageVO);

	/**
	* 导入htmlArea
	* @param htmlAreaVOList
	* @return
	*/
	public int importHtmlArea(List<HtmlAreaVO> htmlAreaVOList);

	/** 根据多个条件对象返回list数据
	*/
	public List<HtmlAreaVO> findHtmlAreaListByVONames(List<HtmlAreaVO> list);

	public int importHtmlAreaCount(HtmlAreaVO htmlAreaVO);

	public int importHtmlAreaUpdate(HtmlAreaVO htmlAreaVO);

	public int importHtmlAreaInsert(HtmlAreaVO htmlAreaVO);
	
}
