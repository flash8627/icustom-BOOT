package com.gwtjs.icustom.common.excel.demo;

import java.util.Date;

import com.gwtjs.icustom.common.excel.annotation.util.ExcelImportField;
import com.gwtjs.icustom.common.excel.annotation.validate.Alias;
import com.gwtjs.icustom.common.excel.annotation.validate.AliasItem;
import com.gwtjs.icustom.common.excel.annotation.validate.Min;
import com.gwtjs.icustom.common.excel.annotation.validate.NotNull;
import com.gwtjs.icustom.common.excel.annotation.validate.Phone;

public class UserDemo {
	
	@ExcelImportField(order=1)
	@NotNull
	private String userName;//登录名
    
	@NotNull
    @ExcelImportField(order=2)
	private String realName;//真实名称
	
	@Alias(values = {@AliasItem(source = "男", target = "1"),@AliasItem(source = "女", target = "2") })
	@ExcelImportField(order=3)
	private Integer sex;//1男2女
	
	@NotNull
    @ExcelImportField(order=4)
	private String idCard;//身份证号
	
	@ExcelImportField(order=5)
	private String tel;//电话
	
	@Phone(message="手机号不正常")
	@ExcelImportField(order=6)
	private String phone;//手机号
	
	@ExcelImportField(order=7)
	@Min(value=1)
	private Integer age;//年龄
	
	@ExcelImportField(order=8)
	private String bkUrl;//博客地址
	
	@ExcelImportField(order=9)
	private Date birth;//生日 
	
}
