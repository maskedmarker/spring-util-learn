package org.example.learn.spring.util.basic.jdbc.client;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.math.BigDecimal;
import java.sql.Driver;
import java.util.List;
import java.util.Map;

public class JdbcTemplateOperationNullableResultTest {

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

    /**
     * 当查不到row时,抛出异常
     */
    @Test
    public void test03() {
        String sql = "select name from t where name = 'not exist'";
        String result = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println("result = " + result);
    }

    /**
     * 当查不到row时,抛出异常
     */
    @Test
    public void test031() {
        String sql = "select name from t where name = 'not exist'";
        String result = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getString(1));
        System.out.println("result = " + result);
    }

    /**
     * 当查不到row时,抛出异常
     */
    @Test
    public void test032() {
        String sql = "select id, name from t where name = 'not exist'";
        UserPO result = jdbcTemplate.queryForObject(sql, new Object[0], (rs, rowNum) -> {
            UserPO userPO = new UserPO();
            userPO.setId(rs.getInt(1));
            userPO.setName(rs.getString(2));

            return userPO;
        });
        System.out.println("result = " + result);
    }


    // region 正确使用方式
    /**
     * 只有以queryForList的方式,才允许返回空
     */
    @Test
    public void test10() {
        String sql = "select name from t where name = 'not exist'";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        System.out.println("result = " + result);
    }

    @Test
    public void test11() {
        String sql = "select id, name from t where name = 'not exist'";
        List<UserPO> result = jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserPO userPO = new UserPO();
            userPO.setId(rs.getInt(1));
            userPO.setName(rs.getString(2));

            return userPO;
        }, new Object[0]);
        System.out.println("result = " + result);
    }
}
