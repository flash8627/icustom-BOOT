/*
 */

package com.gwtjs.icustom.jedis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwtjs.core.log.ICustomLogger;
import com.gwtjs.core.log.ICustomLoggerFactory;
import com.gwtjs.icustom.jedis.client.RedisClient;

@SpringBootApplication
@RestController
public class ICustomJedisApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomJedisApplication.class);
	
	@Autowired
	private RedisClient redisClient;

	public static void main(String[] args) {
		SpringApplication.run(ICustomJedisApplication.class, args);
		log.info("Running with Spring successfull------");
	}
	
	/**
	 * http://localhost:8082/set?key=foo&value=bar
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/set")
	public String set(String key, String value) throws Exception {
		log.info(key+":"+value);
		redisClient.set(key, value);
		return "success";
	}
	
	/**
	 * http://localhost:8082/get?key=foo
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/get")
	public String get(String key) throws Exception {
		log.info(key);
		return redisClient.get(key);
	}
	
}


