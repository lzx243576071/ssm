package com.soecode.web.cache;

import com.soecode.web.entity.SystemInfo;
import com.soecode.web.util.MySubscribe;
import com.soecode.web.util.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by johny on 15/9/24.
 */
public class RedisCacheServiceAdapterImpl implements RedisCacheServiceAdapter<Object> {
	private static Logger logger = LoggerFactory.getLogger(RedisCacheServiceAdapterImpl.class);


	// Redis服务器IP
	private String host;

	// 实例id
	private String codeId;

	// Redis的端口号
	private int port;

	// 访问密码
	private String password;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private int MAX_IDLE = 100;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private int TIME_OUT = 3000;

	private int MAX_TOTAL = 300;

	private JedisPool pool;

	@Override
	public void init() {
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大空闲连接数, 应用自己评估，不要超过KVStore每个实例最大的连接数
		config.setMaxIdle(MAX_IDLE);
		// 最大连接数, 应用自己评估，不要超过KVStore每个实例最大的连接数
		config.setMaxTotal(MAX_TOTAL);
		config.setTestOnBorrow(false);
		config.setTestOnReturn(false);

		pool = new JedisPool(config, host, port, TIME_OUT, password);
	}

	public void destroy(){
		if(pool != null){
			pool.destroy();
		}

	}

	@Override
	public Object get(String key) {
		Jedis jedis = pool.getResource();
		if (jedis == null) {
			return null;
		}

		try {
			byte[] value = jedis.get(key.getBytes());
			if (null == value) {
				return null;
			}

			return SerializeUtil.unserialize(value);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}


	}

	@Override
	public String set(String key, Object object) {
		Jedis jedis = pool.getResource();
		if (jedis == null) {
			return null;
		}

		try {
			return jedis.set(key.getBytes(), SerializeUtil.serialize(object));
		 }finally {
			if (jedis != null) {
				jedis.close();
			}
		}

	}

	@Override
	public Long setnx(String key, Object object, int expried) {
		Jedis jedis = pool.getResource();
		if (jedis == null) {
			return null;
		}
		Long ret;
		try {
			ret = jedis.setnx(key.getBytes(), SerializeUtil.serialize(object));
			jedis.expire(key.getBytes(), expried);
		 }finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return ret;
	}

	@Override
	public String set(String key, Object object, int expried) {
		Jedis jedis = pool.getResource();
		if (jedis == null) {
			return null;
		}

		String ret = null;
		try {
			ret = jedis.set(key.getBytes(), SerializeUtil.serialize(object));
			jedis.expire(key.getBytes(), expried);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

		return ret;
	}

	@Override
	public boolean del(String key) {
		Jedis jedis = pool.getResource();
		if (jedis == null) {
			return false;
		}

		try {
			return jedis.del(key.getBytes()) > 0;
		}  finally {
			if (jedis != null) {

				jedis.close();
			}
		}


	}



	@Override
	public synchronized boolean acquireLock(String lock, int expired) {
		if(expired == 0){
			expired = 3000;
		}


		Jedis jedis = pool.getResource();

		try {
				long value = System.currentTimeMillis() + expired + 1;
				// 1. 通过SETNX试图获取一个lock
				long acquired = jedis.setnx(lock, String.valueOf(value));

				//SETNX成功，则成功获取一个锁
				if (acquired == 1)
					return true;

					//SETNX失败，说明锁仍然被其他对象保持，检查其是否已经超时
				long oldValue = Long.parseLong(jedis.get(lock));

				//超时
				if (oldValue < System.currentTimeMillis()) {
					String getValue = jedis.getSet(lock, String.valueOf(value));
					// 获取锁成功
					if (Long.parseLong(getValue) == oldValue)
						return true;
				}


			//未超时，则直接返回失败

		}catch(Exception e){
			logger.error("acquireLock error ==> ",e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

		return false;

	}

	//释放锁
	@Override
	public synchronized void releaseLock(String lock) {
		Jedis jedis = pool.getResource();

		try {
//			long current = System.currentTimeMillis();
//			// 避免删除非自己获取得到的锁
//			if (current < Long.valueOf(jedis.get(lock)))

			jedis.del(lock);

		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {

		//
		// <property name="host"
		// value="56870cdf50d44bc6.m.cnhza.kvstore.aliyuncs.com"></property>
		// <property name="codeId" value="56870cdf50d44bc6"></property>
		// <property name="port" value="6379"></property>
		// <property name="password" value="m36j44l"></property>

		JedisPoolConfig config = new JedisPoolConfig();
		// 最大空闲连接数, 应用自己评估，不要超过KVStore每个实例最大的连接数
		config.setMaxIdle(20);
		// 最大连接数, 应用自己评估，不要超过KVStore每个实例最大的连接数
		config.setMaxTotal(20);
		config.setTestOnBorrow(false);
		config.setTestOnReturn(false);

		String host = "121.41.51.231";
		String password = "e182fb07be6644d0:DailyRedi2";
		final JedisPool pool = new JedisPool(config, host, 6380, 3000, password);

		Jedis jedis = null;

		try {
			jedis = pool.getResource();

			jedis.subscribe(new MySubscribe(), "*");


			/// ... do stuff here ... for example

			SystemInfo systemInfo = new SystemInfo();
			systemInfo.setSysId(1111);
			systemInfo.setSysUserName("ddss");

			String key = "xxxxxx";
			try {
				jedis.publish("expire","111");//.set(key.getBytes(), SerializeUtil.serialize(user));

				jedis.expire(key.getBytes(), 100);


				try {
					Thread.sleep(10000L);
				} catch (InterruptedException e) {

				}


			}catch(Exception e){
				e.printStackTrace();
			}


		} catch(Exception ee){
			ee.printStackTrace();
		}finally {
			if (jedis != null) {
				jedis.close();

			}
		}



	}

}
