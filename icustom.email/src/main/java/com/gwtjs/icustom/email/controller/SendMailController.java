package com.gwtjs.icustom.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class SendMailController {

	@Autowired
	private MailSender mailSender;

	private SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

	@RequestMapping(value = "/sendmsg", method = RequestMethod.GET)
	@ResponseBody
	public String sendMessage() {

		simpleMailMessage.setSubject("~-Test-~");
		simpleMailMessage.setText("test");
		simpleMailMessage.setFrom("嘻嘻嘻");
		simpleMailMessage.setTo("嘻嘻嘻");

		mailSender.send(simpleMailMessage);

		return "Mail Sent";

	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String getHello() {
		return "Hello";
	}

}
