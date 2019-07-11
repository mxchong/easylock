package mxc.sdk.lock.distribute.mysql;

import mxc.sdk.lock.distribute.DistributeAbstractLock;
import mxc.sdk.lock.exception.MysqlDistributeLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description
 * @Author chenkaideng
 * @Date 2019/7/9
 **/
public class MysqlDistributeLock extends DistributeAbstractLock {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void lock(String key) {
        if (isLocked(key)) {
            throw new MysqlDistributeLockException("lock failed");
        }
        String sql = String.format("insert into `lock` (`key`, `status`) values ('%s', 1) on duplicate key update `status` = 1;", key, key);
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new MysqlDistributeLockException("lock failed");
        }
    }

    @Override
    public void unlock(String key) {
        if (!isLocked(key)) {
            throw new MysqlDistributeLockException("unlock failed");
        }
        String sql = String.format("update `lock` set `status` = 0 where `key` = '%s'", key);
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new MysqlDistributeLockException("unlock failed");
        }
    }

    @Override
    public boolean isLocked(String key) {
        String sql = String.format("select count(1) from `lock` where `key` = '%s' and `status` = 1", key);
        try {
            Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
            return num == 1 ? true : false;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new MysqlDistributeLockException("find lock failed");
        }
    }
}
