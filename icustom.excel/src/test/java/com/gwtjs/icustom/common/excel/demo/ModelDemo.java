package com.gwtjs.icustom.common.excel.demo;

import com.gwtjs.icustom.common.excel.annotation.util.ExcelField;

/**
 * 验证类型及排序
 * @author aGuang
 *
 */
public class ModelDemo {

	@ExcelField(title = "主键Id",order=2)
	private Integer id;
	
	@ExcelField(title = "formKeyk字段名",order=3)
	private String formKey;
	
	@ExcelField(title = "字段分值",order=1)
	private String formValue;
	
	@ExcelField(title = "类型",order=10)
	private Integer type;
	
	@ExcelField(title = "说明",order=11)
	private String description;//说明
	
	@ExcelField(title = "排序",order=4)
	private Integer sort;
	
	@ExcelField(title = "创建时间",order=13)
	private java.util.Date createTime;
	
	@ExcelField(title = "修改时间",order=12)
	private java.util.Date updateTime;
	
	private Integer delFlag;

}
