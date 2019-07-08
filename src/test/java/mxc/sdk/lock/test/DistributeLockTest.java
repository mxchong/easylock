package mxc.sdk.lock.test;

import mxc.sdk.lock.distribute.redis.RedisDistributeLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/8
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributeLockTest {

    @Autowired
    private RedisDistributeLock redisDistributeLock;

    @Test
    public void testLock() {
        redisDistributeLock.lock("mxc");
//        stringRedisTemplate.opsForValue().setIfAbsent("mxc", "111111", 600, TimeUnit.SECONDS);
//        String mxc = stringRedisTemplate.opsForValue().get("mxc");
//        stringRedisTemplate.delete("mxc");
//        System.out.println(mxc);
    }

    @Test
    public void testUnLock() {
        redisDistributeLock.unlock("mxc");;
    }
}
