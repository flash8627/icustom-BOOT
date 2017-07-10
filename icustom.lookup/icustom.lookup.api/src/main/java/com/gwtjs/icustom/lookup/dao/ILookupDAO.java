package com.gwtjs.icustom.lookup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.icustom.lookup.entity.LookupVO;

public interface ILookupDAO{
	
	//
	LookupVO findByItem(LookupVO record);
	
	//
	LookupVO findItem(@Param("classId")Integer classId);

	//
	PagedResult<LookupVO> findLookupPage(@Param("vo")LookupVO record,@Param("page")PageVO page);

	//
	int batchRemovePks(List<LookupVO> records);

	//
	int batchUpdate(List<LookupVO> records);

	//
	int batchInsert(List<LookupVO> records);

}
