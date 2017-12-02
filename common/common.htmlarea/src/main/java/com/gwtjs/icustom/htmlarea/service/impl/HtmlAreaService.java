package com.gwtjs.icustom.htmlarea.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.htmlarea.dao.IHtmlAreaDao;
import com.gwtjs.icustom.htmlarea.service.IHtmlAreaService;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;
import com.gwtjs.icustom.kindeditor.util.HtmlSpecialChars;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

import io.swagger.annotations.Api;

@Api("/htmlAreaService")  @Service("htmlAreaService") @Named("htmlAreaService")
public class HtmlAreaService implements IHtmlAreaService {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(HtmlAreaService.class);
	
	@Inject
	private IHtmlAreaDao htmlAreaDao;
	
	/**
	 * 保存或修改  merge动作
	 * @param sys
	 * @return
	 */
	@Override
	public ResultWrapper saveOrUpdate(HtmlAreaVO vo) {
		
		//String html = HtmlSpecialChars.inHtmlspecialchars(vo.getContent());

		//log.info("\n>>>>>>>>findHtmlAreaPage html-----",html);
		//vo.setContent(html);
		
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		list.add(vo);
		return batchSaveOrUpdate(list);
	}
	
	/**
	 * 保存或修改  merge动作
	 * @param sys
	 * @return
	 */
	@Override
	public ResultWrapper batchSaveOrUpdate(List<HtmlAreaVO> list) {
		int result = htmlAreaDao.saveOrUpdate(list);
		return ResultWrapper.successResult(result);
	}
	
	/**
	 * 查询所有,没有过滤条件
	 * @return
	 */
	@Override
	public List<HtmlAreaVO> findAll() {
		
		return htmlAreaDao.findAll();
	}
	
	/**
	 * 查询特定富文本  htmlAreaId
	 * @return
	 */
	@Override
	public HtmlAreaVO findHtmlArea(Integer htmlAreaId) {
		
		return htmlAreaDao.findHtmlArea(htmlAreaId);
	}
	
	/**
	 * 查询名称,模糊查询
	 * @return 
	 */
	@Override
	public PagedResult<HtmlAreaVO> findHtmlAreaPage(HtmlAreaVO vo,PageVO page) {
		log.info("\n>>>>>>>>findHtmlAreaPage vo------",vo);
		log.info("\n>>>>>>>>findHtmlAreaPage po------",page);
		log.info("\n>>>>>>>>findHtmlAreaPage dao-----",htmlAreaDao);
		return htmlAreaDao.findHtmlAreaPage(vo, page);
	}
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	@Override
	public ResultWrapper batchRemovePks(List<HtmlAreaVO> records) {
		int result = htmlAreaDao.batchRemovePks(records);
		return ResultWrapper.successResult(result);
	}
	
}
