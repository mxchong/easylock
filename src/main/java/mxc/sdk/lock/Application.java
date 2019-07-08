package mxc.sdk.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/8
 **/
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
//        DistributeAbstractLock distributeAbstractLock = new RedisDistributeLock();
//        distributeAbstractLock.lock("mxc");
    }
}
