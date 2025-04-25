package org.example.learn.spring.util.basic.file;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

public class ClassPathResourceTest {

    @Test
    public void test0() throws IOException {
        // 这里必须是classpath的绝对路径
        ClassPathResource classPathResource = new ClassPathResource("example.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(classPathResource, StandardCharsets.UTF_8));
        System.out.println("properties = " + properties);
    }
}
