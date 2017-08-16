package com.gwtjs.icustom.springsecurity.region.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.ForecastVO;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;

@Mapper
public interface IRegionForecastHeaderDao {
	
	int initLargeTOForecast();
	
	int initSmallTOForecast();

	PagedResult<SysResourceVO> queryRegionForecast(@Param("vo")ForecastVO vo,@Param("page")PageVO page);
	PagedResult<SysResourceVO> queryRegionCurrentForecast(@Param("vo")ForecastVO vo,@Param("page")PageVO page);
	
}
