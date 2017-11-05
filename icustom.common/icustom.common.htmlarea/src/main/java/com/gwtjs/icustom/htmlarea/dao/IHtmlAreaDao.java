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
	
}
