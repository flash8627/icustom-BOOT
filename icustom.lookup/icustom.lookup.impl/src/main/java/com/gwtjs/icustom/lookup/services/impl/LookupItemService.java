package com.gwtjs.icustom.lookup.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.icustom.lookup.dao.ILookupItemDAO;
import com.gwtjs.icustom.lookup.entity.LookupItemVO;
import com.gwtjs.icustom.lookup.services.ILookupItemService;

/**
 * lookup 条目
 * 
 * @author aGuang
 *
 */
@Named("lookupItemService")
public class LookupItemService implements ILookupItemService {

	@Inject
	private ILookupItemDAO lookupItemDao;
	
	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<LookupItemVO> findRecords(LookupItemVO record, PageVO page) {
		PagedResult<LookupItemVO> paged = new PagedResult<LookupItemVO>();
		PageVO pageVO = new PageVO();
		if(pageVO.getTotalRows()>0){
			paged.setPageVO(pageVO);
			paged.setResult(lookupItemDao.selectList(record, page));
		}
		return paged;
	}

	@Override
	public ResultWrapper findLookupItems(Integer classId) {
		return ResultWrapper.successResult(lookupItemDao.findLookupItems(classId));
	}

	@Override
	public ResultWrapper findItem(Integer itemId) {
		return ResultWrapper.successResult(lookupItemDao.findItem(itemId));
	}

	@Override
	public ResultWrapper selectListCount(LookupItemVO record) {
		return null;//ResultWrapper.successResult(lookupItemDao.selectListCount(record));
	}

	@Override
	public ResultWrapper batchRemovePks(List<LookupItemVO> records) {
		return ResultWrapper.successResult(lookupItemDao.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<LookupItemVO> records) {
		records = setRecordsUser(records);
		lookupItemDao.batchUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<LookupItemVO> records) {
		records = setRecordsUser(records);
		lookupItemDao.batchInsert(records);
		return genericResult(records);
	}
	
	private ResultWrapper genericResult(List<LookupItemVO> list)
	{
		List<LookupItemVO> records = new ArrayList<LookupItemVO>();
		for (LookupItemVO item : list) {
			records.add(lookupItemDao.findByItem(item));
		}
		return ResultWrapper.successResult(records);
	}
	
	/**
	 * 设置当前操作用户 
	 * @param records
	 * @return
	 */
	private List<LookupItemVO> setRecordsUser(List<LookupItemVO> records){
		List<LookupItemVO> result = new ArrayList<LookupItemVO>();
		long createdUser = new Long(1);
		
		for (LookupItemVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
