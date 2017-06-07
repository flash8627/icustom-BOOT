package com.gwtjs.icustom.jedis.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 就一个小Demo 随便写下
 * @author bigsea
 *
 */
public class RedisClient {

	private JedisPool jedisPool;
	
	public void set(String key, String value) throws Exception {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} finally {
			//返还到连接池
			jedis.close();
		}
	}
	
	public String get(String key) throws Exception  {

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.get(key);
		} finally {
			//返还到连接池
			jedis.close();
		}
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
}
