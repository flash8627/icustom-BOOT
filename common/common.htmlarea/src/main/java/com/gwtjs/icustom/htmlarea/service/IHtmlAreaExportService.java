package com.gwtjs.icustom.htmlarea.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;

/**
* HtmlArea导出报表
*/
@Path("/export")
@Produces("application/json")
public interface IHtmlAreaExportService {
	
	/**
	* classify页面导出
	*
	* @author f00196405
	* @throws ExcelApplicationException
	*/
	@GET
	@Path("/single")
	public void exportHtmlAreaByIExcel(@QueryParam("") HtmlAreaVO htmlAreaVO);
	
}
