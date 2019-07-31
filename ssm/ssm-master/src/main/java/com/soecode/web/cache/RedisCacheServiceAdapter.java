package com.soecode.web.cache;


public interface RedisCacheServiceAdapter<V> {

	V get(String key);

	String set(String key, V value);

	String set(String key, V value, int expried);

	boolean del(String key);

 
	public void init();
 

	boolean acquireLock(String lock, int expired);

	//释放锁
	void releaseLock(String lock);
	
	Long setnx(String key, Object object, int expried);
 
}
