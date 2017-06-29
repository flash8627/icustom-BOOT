package com.gwtjs.icustom.springsecurity.jaxrs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.ForecastVO;
import com.gwtjs.icustom.springsecurity.entity.SysResource;

@Mapper
public interface IRegionForecastDao {
	
	int insert();
	
	int initLargeTOForecast();
	
	int initSmallTOForecast();

	PagedResult<SysResource> queryRegionForecast(@Param("vo")ForecastVO vo,@Param("page")PageVO page);
	PagedResult<SysResource> queryRegionCurrentForecast(@Param("vo")ForecastVO vo,@Param("page")PageVO page);
	
}
