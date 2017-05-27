package com.gwtjs.register.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.mapper.BaseSqlMapper;
import com.gwtjs.register.entity.RegisterVO;

/**
 * 数据字典
 * @author aGuang
 *
 */
public interface IRegisterDAO extends BaseSqlMapper<RegisterVO> {
	
	//
	RegisterVO getByPathRegister(RegisterVO reg);
	
	//
	RegisterVO findItem(@Param("regId")Integer regId);
	
	//
	List<RegisterVO> findRegisterList(RegisterVO record);
	
	//
	List<RegisterVO> selectList(@Param("vo")RegisterVO record,@Param("page")PageVO page);
	
	//
	List<RegisterVO> findItems(RegisterVO record);

	//
	int batchRemovePks(List<RegisterVO> records);

	//
	int batchUpdate(List<RegisterVO> records);

	//
	int batchInsert(List<RegisterVO> records);

}