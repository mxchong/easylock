package mxc.sdk.lock.distribute.redis;

import java.util.concurrent.TimeUnit;

import mxc.sdk.lock.distribute.DistributeAbstractLock;
import mxc.sdk.lock.exception.RedisDistributeLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Description redis实现分布式锁
 * @Author chenkaideng
 * @Date 2019/7/8
 **/
public class RedisDistributeLock extends DistributeAbstractLock {

    private static final String PREFIX = "district:lock:";
    private static final int LOCK_EXPIRATION_TIME = 60 * 1000;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void lock(String key) {
        boolean isLockSuccess = locking(key);
        if (!isLockSuccess) {
            throw new RedisDistributeLockException("lock failed");
        }
    }

    public void unlock(String key) {
        boolean isUnlockSuccess = unlocking(key);
        if (!isUnlockSuccess) {
            throw new RedisDistributeLockException("unlock failed");
        }
    }

    private String buildLockKey(String key) {
        return new StringBuilder().append(PREFIX).append(key).toString();
    }

    /**
     * 上锁
     * @param key
     * @return
     */
    private boolean locking(String key) {
        String lockKey = buildLockKey(key);
        String lockValue = String.valueOf(Thread.currentThread().getId());
        return stringRedisTemplate.opsForValue().setIfAbsent(lockKey, lockValue, LOCK_EXPIRATION_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * 解锁
     * 不够严谨，get比对然后才del，整个过程不够原子，可以用lua脚本
     * 但是，我采用了线程id比对，所以就算
     * @param key
     * @return
     */
    private boolean unlocking(String key) {
        String lockKey = buildLockKey(key);
        String lockValue = stringRedisTemplate.opsForValue().get(lockKey);
        String currentThreadId = String.valueOf(Thread.currentThread().getId());
        if (null != lockValue && lockValue.equals(currentThreadId)) {
            return stringRedisTemplate.delete(lockKey);
        }
        return false;
    }
}
