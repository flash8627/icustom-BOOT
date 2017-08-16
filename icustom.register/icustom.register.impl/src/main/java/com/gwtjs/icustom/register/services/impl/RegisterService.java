package com.gwtjs.icustom.register.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.register.dao.IRegisterDAO;
import com.gwtjs.icustom.register.entity.RegisterVO;
import com.gwtjs.icustom.register.services.IRegisterService;

/**
 * 数据字典
 * 
 * @author aGuang
 *
 */
@Named("registerService")
public class RegisterService implements IRegisterService {

	@Inject
	private IRegisterDAO registerDAO;

	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<RegisterVO> findRecords(RegisterVO record, PageVO page) {
		PagedResult<RegisterVO> paged = new PagedResult<RegisterVO>();
		PageVO pageVO = new PageVO();
		//pageVO.setTotalRows(registerDAO.selectListCount(record, page));
		if (pageVO.getTotalRows() > 0) {
			paged.setPageVO(pageVO);
			paged.setResult(registerDAO.selectList(record, page));
		}
		return paged;
	}

	@Override
	public ResultWrapper findItem(Integer regId) {
		return ResultWrapper.successResult(registerDAO.findItem(regId));
	}

	private List<RegisterVO> getTree(RegisterVO record) {
		List<RegisterVO> list = registerDAO.findItems(record);
		for (RegisterVO tree : list) {
			if (tree.isLeaf()) {
				tree.setChildren(getTree(tree));
			}
		}
		return list;
	}

	@Override
	public List<RegisterVO> findRegisterList(RegisterVO record) {
		List<RegisterVO> records = registerDAO.findItems(record);
		for (RegisterVO tree : records) {
			List<RegisterVO> children = getTree(tree);

			tree.setChildren(children);
		}
		return records;
	}

	@Override
	public ResultWrapper batchRemovePks(List<RegisterVO> records) {
		return ResultWrapper.successResult(registerDAO.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<RegisterVO> records) {
		records = setRecordsUser(records);
		registerDAO.batchUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<RegisterVO> records) {
		records = setRecordsUser(records);
		registerDAO.batchInsert(records);
		List<RegisterVO> result = new ArrayList<RegisterVO>();
		for (RegisterVO reg : records) {
			RegisterVO vo = registerDAO.getByPathRegister(reg);
			result.add(vo);
		}
		return ResultWrapper.successResult(result);
	}

	/**
	 * 设置当前操作用户
	 * 
	 * @param records
	 * @return
	 */
	private List<RegisterVO> setRecordsUser(List<RegisterVO> records) {
		List<RegisterVO> result = new ArrayList<RegisterVO>();
		long createdUser = new Long(10001);

		for (RegisterVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
