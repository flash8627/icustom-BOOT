package com.gwtjs.icustom.common.htmlarea.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.common.htmlarea.dao.IHtmlAreaDao;
import com.gwtjs.icustom.common.htmlarea.service.IHtmlAreaService;
import com.gwtjs.icustom.common.htmlarea.vo.HtmlAreaVO;
import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;

import io.swagger.annotations.Api;

@Api("/")  @Service("htmlAreaService")
public class HtmlAreaService implements IHtmlAreaService {
	
	@Inject
	private IHtmlAreaDao htmlAreaDao;
	
	/**
	 * 保存或修改  merge动作
	 * @param sys
	 * @return
	 */
	@Override
	public ResultWrapper saveOrUpdate(List<HtmlAreaVO> list) {
		return null;
	}
	
	/**
	 * 查询所有,没有过滤条件
	 * @return
	 */
	@Override
	public List<HtmlAreaVO> findAll() {
		return null;
	}
	
	/**
	 * 查询特定富文本  htmlAreaId
	 * @return
	 */
	@Override
	public HtmlAreaVO findByHtmlArea(@Param("htmlAreaId") Integer htmlAreaId) {
		return null;
	}
	
	/**
	 * 查询名称,模糊查询
	 * @return
	 */
	@Override
	public PagedResult<HtmlAreaVO> findHtmlAreaPage(@Param("vo") HtmlAreaVO sys,@Param("page") PageVO page) {
		return null;
	}
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	@Override
	public ResultWrapper batchRemovePks(List<HtmlAreaVO> records) {
		return null;
	}
	
}
