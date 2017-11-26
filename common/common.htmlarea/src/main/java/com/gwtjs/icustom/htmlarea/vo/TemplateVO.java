package com.gwtjs.icustom.htmlarea.vo;

import com.gwtjs.icustom.entity.BaseResource;

/**
 * 邮件模板VO
 */
public class TemplateVO extends BaseResource {

	private static final long serialVersionUID = 7660972722873061374L;

	private String templateTitle;
	private String templateName;
	private String templateType;

	public String getTemplateTitle() {
		return templateTitle;
	}

	public void setTemplateTitle(String templateTitle) {
		this.templateTitle = templateTitle;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

}
