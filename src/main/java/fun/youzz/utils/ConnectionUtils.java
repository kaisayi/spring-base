package fun.youzz.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

/**
 * 链接的工具类，从数据源中获取一个链接，并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection() {
        // 1. 从ThreadLocal上获取
        Connection conn = threadLocal.get();
        // 2. 判断当前线程上是否有连接
        if (Objects.isNull(conn)) {
            // 3. 从数据源中获取一个连接，并且存入TheadLocal中
            try {
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // 4. 返回当前线程上的连接
        return conn;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        threadLocal.remove();
    }

}
