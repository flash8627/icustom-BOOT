package com.gwtjs.icustom.international.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.international.entity.LanguageVO;

public interface InternationalDAO{
	
	//
	LanguageVO findByItem(LanguageVO lan);
	
	//
	LanguageVO findItem(@Param("lanId")Long lanId);
	
	//
	LanguageVO i18n(LanguageVO record);

	//
	PagedResult<LanguageVO> findLanguagePage(@Param("vo")LanguageVO record,@Param("page")PageVO page);
	
	//
	int batchRemovePks(List<LanguageVO> records);
	
	//
	int batchUpdate(List<LanguageVO> records);

	//
	int batchInsert(List<LanguageVO> records);
	
}
