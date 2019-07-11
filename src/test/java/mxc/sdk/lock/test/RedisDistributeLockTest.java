package mxc.sdk.lock.test;

import mxc.sdk.lock.distribute.redis.RedisDistributeLock;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/8
 **/
@Ignore
public class RedisDistributeLockTest extends BaseTest {

    @Autowired
    private RedisDistributeLock redisDistributeLock;

    @Test
    public void testLock() {
        redisDistributeLock.lock("mxc");
    }

    @Test
    public void testUnLock() {
        redisDistributeLock.unlock("mxc");;
    }

    @Test
    public void testIsLocked() {
        Assert.assertTrue(redisDistributeLock.isLocked("mxc"));
    }
}
