package org.example.learn.spring.util.basic.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 关于properties文件的读取
 */
public class PropertiesFileTest {

    @Test
    public void test01() throws IOException {
        // 默认使用ISO-8859-1 encoding
        Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("example.properties"));
        String value1 = properties.getProperty("key1");
        Assert.assertEquals("value1", value1);
        String value2 = properties.getProperty("key2");
        Assert.assertEquals("value2", value2);
    }

    @Test
    public void test02() throws IOException {
        // 不指定编码时,默认使用ISO-8859-1 encoding
        Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("example.properties"));
        String value3 = properties.getProperty("key3");
        Assert.assertEquals("中文", value3);
    }

    @Test
    public void test03() throws IOException {
        // 指定编码
        Properties properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(new ClassPathResource("example.properties"), StandardCharsets.UTF_8));
        String value3 = properties.getProperty("key3");
        Assert.assertEquals("中文", value3);
    }
}
