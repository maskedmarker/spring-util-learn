package org.example.learn.spring.util.boot.prop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class BinderTest {

    @Autowired
    Environment environment;

    @Test
    public void test0() {
        // 创建 Binder 实例
        Binder binder = Binder.get(environment);

        // 从配置文件中读取单个属性
        String someProperty = binder.bind("app.some-property", String.class).orElse("default-value");
        System.out.println("someProperty = " + someProperty);
    }

    /**
     * 绑定到自定义对象类型
     */
    @Test
    public void test1() {
        // 创建 Binder 实例
        Binder binder = Binder.get(environment);

        // 绑定到自定义对象类型
        ServerConfig serverConfig = binder.bind("server", ServerConfig.class).orElse(new ServerConfig());
        System.out.println("serverConfig = " + serverConfig);
    }

    /**
     * 绑定嵌套属性
     */
    @Test
    public void test2() {
        // 创建 Binder 实例
        Binder binder = Binder.get(environment);

        // 绑定嵌套属性
        AppSettings appSettings = binder.bind("app.settings", AppSettings.class).orElse(new AppSettings());
        System.out.println("appSettings = " + appSettings);
    }
}
