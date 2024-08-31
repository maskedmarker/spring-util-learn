package org.example.learn.spring.util.basic.jdbc.client;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.math.BigDecimal;
import java.sql.Driver;

public class JdbcTemplateTest {

    private static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String TEST_SQL = "select 1 from dual";

    private static final String JDBC_URL = "jdbc:mysql://192.168.175.129:3306/test01";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "123456";

    @Test
    public void test0() throws ClassNotFoundException {
        // 创建 SimpleDriverDataSource 实例
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        // 设置数据库驱动类名
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(JDBC_DRIVER_CLASS_NAME));
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USERNAME);
        dataSource.setPassword(JDBC_PASSWORD);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        BigDecimal result = jdbcTemplate.queryForObject(TEST_SQL, BigDecimal.class);
        System.out.println("result = " + result);
    }
}
