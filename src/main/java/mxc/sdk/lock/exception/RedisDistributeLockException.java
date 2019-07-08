package mxc.sdk.lock.exception;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/8
 **/
public class RedisDistributeLockException extends RuntimeException{

    public RedisDistributeLockException(String message) {
        super(message);
    }

    public RedisDistributeLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
