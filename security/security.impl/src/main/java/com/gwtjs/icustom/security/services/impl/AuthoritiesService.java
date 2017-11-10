package com.gwtjs.icustom.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.security.dao.IAuthoritiesDAO;
import com.gwtjs.icustom.security.entity.SysAuthoritiesVO;
import com.gwtjs.icustom.security.services.IAuthoritiesService;

@Named("authoritiesService")
public class AuthoritiesService implements IAuthoritiesService {
	
	@Inject
	private IAuthoritiesDAO authoritiesDAO;
	
	@Override
	public List<SysAuthoritiesVO> findAuthoritiesTree(SysAuthoritiesVO auth) {
		List<SysAuthoritiesVO> records = authoritiesDAO.findAuthoritiesTree(auth);
		/*for (SysAuthoritiesVO record : records) {
			List<SysAuthoritiesVO> children = getTree(record);
			record.setChildren(children);
		}*/
		return records;
	}

	/**
	 * 分页的权限 条目
	 */
	@Override
	public PagedResult<SysAuthoritiesVO> findAuthoritiesList(SysAuthoritiesVO record, PageVO page) {
		PagedResult<SysAuthoritiesVO> paged = new PagedResult<SysAuthoritiesVO>();
		PageVO pageVO = new PageVO();
		pageVO.setTotalRows(authoritiesDAO.findAuthoritiesListCount(record, page));
		if (pageVO.getTotalRows() > 0) {
			paged.setPageVO(pageVO);
			paged.setResult(authoritiesDAO.findAuthoritiesList(record, page));
		}
		return paged;
	}

	@Override
	public ResultWrapper findItem(Integer regId) {
		return ResultWrapper.successResult(authoritiesDAO.findItem(regId));
	}

	@Override
	public ResultWrapper batchRemovePks(List<SysAuthoritiesVO> records) {
		return ResultWrapper.successResult(authoritiesDAO.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<SysAuthoritiesVO> records) {
		records = setRecordsUser(records);
		authoritiesDAO.batchUpdate(records);
		return ResultWrapper.successResult(records);
	}

	@Override
	public ResultWrapper batchInsert(List<SysAuthoritiesVO> records) {
		records = setRecordsUser(records);
		authoritiesDAO.batchInsert(records);
		List<SysAuthoritiesVO> result = new ArrayList<SysAuthoritiesVO>();
		for (SysAuthoritiesVO reg : records) {
			SysAuthoritiesVO vo = authoritiesDAO.getByPathAuthorities(reg);
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
	private List<SysAuthoritiesVO> setRecordsUser(List<SysAuthoritiesVO> records) {
		List<SysAuthoritiesVO> result = new ArrayList<SysAuthoritiesVO>();
		long createdUser = new Long(10001);

		for (SysAuthoritiesVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}
	
}
