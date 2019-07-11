package mxc.sdk.lock.distribute;

/**
 * @Description 锁抽象
 * @Author chenkaideng
 * @Date 2019/7/2
 **/
public abstract class DistributeAbstractLock {

    public abstract void lock(String key);

    public abstract void unlock(String key);

    public abstract boolean isLocked(String key);
}
