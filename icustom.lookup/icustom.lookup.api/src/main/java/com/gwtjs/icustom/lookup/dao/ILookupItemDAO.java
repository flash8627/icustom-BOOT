package com.gwtjs.icustom.lookup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.lookup.entity.LookupItemVO;

public interface ILookupItemDAO{
	
	//
	LookupItemVO findItem(@Param("itemId")Integer itemId);
	
	//
	LookupItemVO findByItem(LookupItemVO record);

	//
	List<LookupItemVO> findLookupItems(@Param("classId")Integer classId);
	
	//
	List<LookupItemVO> selectList(@Param("vo")LookupItemVO record,@Param("page")PageVO page);

	//
	int batchRemovePks(List<LookupItemVO> records);

	//
	int batchUpdate(List<LookupItemVO> records);

	//
	int batchInsert(List<LookupItemVO> records);

}