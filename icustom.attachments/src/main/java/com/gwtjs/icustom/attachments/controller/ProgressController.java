package com.gwtjs.icustom.attachments.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gwtjs.icustom.attachments.model.FileUploadStatus;

@Controller  
@SessionAttributes("status")
public class ProgressController {
	
	@RequestMapping(value = "/attachments/upload/progress", method = RequestMethod.POST )
	@ResponseBody
	public String initCreateInfo(Map<String, Object> model) {
		FileUploadStatus status = (FileUploadStatus) model.get("status");
		if(status==null){
			return "{}";
		}
		return status.toString();
	}
	
}
