package org.example.learn.spring.util.basic.jdbc.client;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.math.BigDecimal;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateOperationTest {

    private static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String TEST_SQL = "select 1 from dual";

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() throws ClassNotFoundException {
        String jdbcUrl = "jdbc:mysql://192.168.175.129:3306/test01";
        String userName = "root";
        String password = "123456";

        // 创建 SimpleDriverDataSource 实例
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(JDBC_DRIVER_CLASS_NAME));
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // region 返回单行单列
    /**
     * 基于sql的返回值,使用准确的类型
     */
    @Test
    public void test01() {
        String sql = "select id from t limit 1";
        BigDecimal result = jdbcTemplate.queryForObject(sql, BigDecimal.class);
        System.out.println("result = " + result);
    }

    @Test
    public void test02() {
        String sql = "select name from t limit 1";
        String result = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println("result = " + result);
    }

    // region 返回单行多列
    @Test
    public void test10() {
        String sql = "select id, name from t limit 1";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        System.out.println("result = " + result);
    }

    // region 返回多行单列
    @Test
    public void test20() {
        String sql = "select id from t";
        List<String> result = jdbcTemplate.queryForList(sql, String.class);
        System.out.println("result = " + result);
    }

    // region 返回多行多列
    @Test
    public void test30() {
        String sql = "select id, name from t";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        System.out.println("result = " + result);
    }
}
