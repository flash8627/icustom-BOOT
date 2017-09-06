package com.gwtjs.icustom.common.excel.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.gwtjs.icustom.common.excel.FlagInfoExcelUtils;
import com.gwtjs.icustom.common.excel.Exception.ExcelException;

/**
 * 导出
 * @author aGuang
 *
 */
public class ExportTest {
	
	/**
	 * 有标题导出：
	    参数： param1:导出类 
	      param2：导出的集合
	      param3：是否是 2007，true 是 false 否
	      param4：标题
	      param5：标题行高
	 */
	@Test
	public void exportByObj(){
		List<ModelDemo> list=buildModel();
		try {
			Workbook wb = FlagInfoExcelUtils.getInstance().exportByObj(ModelDemo.class, list, true, "测试导出", 20);
		} catch (ExcelException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 4.2  无标题导出：
	  参数： param1:导出类 
	      param2：导出的集合
	      param3：是否是 2007，true 是 false 否
	 */
	@Test
	public void exportByObjTitle(){
		List<ModelDemo> list=buildModel();
		try {
			Workbook wb = FlagInfoExcelUtils.getInstance().exportByObj(ModelDemo.class, list, true);
		} catch (ExcelException e) {
			e.printStackTrace();
		}
	}
	
	public List<ModelDemo> buildModel()
	{
		List<ModelDemo> list=new ArrayList<ModelDemo>();
		ModelDemo m = new ModelDemo();
		list.add(m);
		return list;
	}
	
}
