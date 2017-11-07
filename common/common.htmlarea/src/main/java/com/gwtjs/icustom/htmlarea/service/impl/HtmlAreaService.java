package com.gwtjs.icustom.htmlarea.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.htmlarea.dao.IHtmlAreaDao;
import com.gwtjs.icustom.htmlarea.service.IHtmlAreaService;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;

import io.swagger.annotations.Api;

@Api("/htmlArea")  @Service("htmlAreaService")
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
		htmlAreaDao.saveOrUpdate(list);
		return null;
	}
	
	/**
	 * 查询所有,没有过滤条件
	 * @return
	 */
	@Override
	public List<HtmlAreaVO> findAll() {
		htmlAreaDao.findAll();
		return null;
	}
	
	/**
	 * 查询特定富文本  htmlAreaId
	 * @return
	 */
	@Override
	public HtmlAreaVO findHtmlArea(Integer htmlAreaId) {
		htmlAreaDao.findHtmlArea(htmlAreaId);
		return null;
	}
	
	/**
	 * 查询名称,模糊查询
	 * @return
	 */
	@Override
	public PagedResult<HtmlAreaVO> findHtmlAreaPage(HtmlAreaVO vo,PageVO page) {
		htmlAreaDao.findHtmlAreaPage(vo, page);
		return null;
	}
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	@Override
	public ResultWrapper batchRemovePks(List<HtmlAreaVO> records) {
		htmlAreaDao.batchRemovePks(records);
		return null;
	}
	
}
