package mxc.sdk.lock.exception;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/10
 **/
public class MysqlDistributeLockException extends RuntimeException {
    public MysqlDistributeLockException(String message) {
        super(message);
    }

    public MysqlDistributeLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
