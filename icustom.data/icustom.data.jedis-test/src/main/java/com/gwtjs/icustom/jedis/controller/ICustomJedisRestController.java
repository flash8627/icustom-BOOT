/*
 */

package com.gwtjs.icustom.jedis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;
import com.gwtjs.icustom.jedis.client.RedisClient;

/*@RestController
public class ICustomJedisRestController {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomJedisRestController.class);
	
	@Autowired
	private RedisClient redisClient;

	@RequestMapping("/set")
	public String set(String key, String value) throws Exception {
		redisClient.set(key, value);
		return "success";
	}

	@RequestMapping("/get")
	public String get(String key) throws Exception {
		return redisClient.get(key);
	}
	
}*/
