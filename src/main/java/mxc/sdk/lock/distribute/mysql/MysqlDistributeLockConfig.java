package mxc.sdk.lock.distribute.mysql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/9
 **/
@Configuration
public class MysqlDistributeLockConfig {

    @Bean
    public MysqlDistributeLock mysqlDistributeLock() {
        return new MysqlDistributeLock();
    }
}
