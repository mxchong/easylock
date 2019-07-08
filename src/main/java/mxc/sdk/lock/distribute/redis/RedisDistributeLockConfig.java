package mxc.sdk.lock.distribute.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/8
 **/
@Configuration
public class RedisDistributeLockConfig {

    @Bean
    public RedisDistributeLock redisDistributeLock() {
        return new RedisDistributeLock();
    }
}
