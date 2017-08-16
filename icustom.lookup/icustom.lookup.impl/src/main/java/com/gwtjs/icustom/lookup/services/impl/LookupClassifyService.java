package com.gwtjs.icustom.lookup.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.lookup.dao.ILookupDAO;
import com.gwtjs.icustom.lookup.entity.LookupVO;
import com.gwtjs.icustom.lookup.services.ILookupClassifyService;

/**
 * lookup分类
 * 
 * @author aGuang
 *
 */
@Named("lookupClassifyService")
public class LookupClassifyService implements ILookupClassifyService {

	@Inject
	private ILookupDAO lookupDao;
	
	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<LookupVO> findListRecords(LookupVO record, PageVO page) {
		return lookupDao.findLookupPage(record, page);
	}
	
	@Override
	public ResultWrapper findItem(Integer classId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(lookupDao.findItem(classId));
	}

	@Override
	public PagedResult<LookupVO> findLookupList(LookupVO record, PageVO page) {
		return findListRecords(record, page);
	}

	@Override
	public ResultWrapper batchRemovePks(List<LookupVO> records) {
		// TODO Auto-generated method stub
		lookupDao.batchRemovePks(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchUpdate(List<LookupVO> records) {
		records = setRecordsUser(records);
		lookupDao.batchUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<LookupVO> records) {
		records = setRecordsUser(records);
		lookupDao.batchInsert(records);
		return genericResult(records);
	}
	
	private ResultWrapper genericResult(List<LookupVO> list)
	{
		List<LookupVO> records = new ArrayList<LookupVO>();
		for (LookupVO look : list) {
			records.add(lookupDao.findByItem(look));
		}
		return ResultWrapper.successResult(records);
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<LookupVO> setRecordsUser(List<LookupVO> records){
		List<LookupVO> result = new ArrayList<LookupVO>();
		long createdUser = new Long(1);
		
		for (LookupVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
