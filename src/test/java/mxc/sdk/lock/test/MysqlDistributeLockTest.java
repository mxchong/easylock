package mxc.sdk.lock.test;

import mxc.sdk.lock.distribute.mysql.MysqlDistributeLock;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/10
 **/
@Ignore
public class MysqlDistributeLockTest extends BaseTest {

    @Autowired
    private MysqlDistributeLock mysqlDistributeLock;

    @Test
    public void testLock() {
        mysqlDistributeLock.lock("mxc");
    }

    @Test
    public void testUnlock() {
        mysqlDistributeLock.unlock("mxc");;
    }

    @Test
    public void testIsLocked() {
        boolean isLocked = mysqlDistributeLock.isLocked("mxc");
        Assert.assertTrue(isLocked);
    }
}
