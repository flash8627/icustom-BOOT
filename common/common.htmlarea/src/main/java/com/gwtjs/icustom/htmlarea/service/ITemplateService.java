package com.gwtjs.icustom.htmlarea.service;

import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.gwtjs.icustom.htmlarea.vo.TemplateVO;

/**
 * 模板服务
 * 
 * @version:
 */
public interface ITemplateService {
	/**
	 * 根据模板类型和name获取模板
	 * 
	 * @return
	 */
	TemplateVO findTemplate(String templateType, String templateName) throws ApplicationException;

	/**
	 * 获取所有邮件模板
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	List<TemplateVO> findTemplates(String templateType) throws ApplicationException;

}
