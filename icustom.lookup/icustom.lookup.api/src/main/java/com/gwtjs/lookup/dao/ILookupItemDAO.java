package com.gwtjs.lookup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.mapper.BaseSqlMapper;
import com.gwtjs.lookup.entity.LookupItemVO;

public interface ILookupItemDAO extends BaseSqlMapper<LookupItemVO> {
	
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