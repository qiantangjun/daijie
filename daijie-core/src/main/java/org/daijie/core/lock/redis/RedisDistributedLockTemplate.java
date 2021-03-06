package org.daijie.core.lock.redis;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.daijie.core.lock.Callback;
import org.daijie.core.lock.DistributedLockTemplate;

/**
 * 获取分页式锁执行回调函数
 * @author daijie_jay
 * @date 2017年11月24日
 */
public class RedisDistributedLockTemplate implements DistributedLockTemplate {
	
	private static final Logger logger = Logger.getLogger(RedisDistributedLockTemplate.class);

    private Object jedisLock;

    public RedisDistributedLockTemplate(Object jedisLock) {
        this.jedisLock = jedisLock;
    }

    public Object execute(String lockId, int timeout, Callback callback) {
        RedisReentrantLock distributedReentrantLock = null;
        boolean getLock=false;
        try {
            distributedReentrantLock = new RedisReentrantLock(jedisLock,lockId);
            if(distributedReentrantLock.tryLock(new Long(timeout), TimeUnit.MILLISECONDS)){
                getLock=true;
                return callback.onGetLock();
            }else{
                return callback.onTimeout();
            }
        }catch(InterruptedException ex){
        	logger.error(ex.getMessage(), ex);
            Thread.currentThread().interrupt();
        }catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }finally {
            if(getLock) {
                distributedReentrantLock.unlock();
            }
        }
        return null;
    }
}
