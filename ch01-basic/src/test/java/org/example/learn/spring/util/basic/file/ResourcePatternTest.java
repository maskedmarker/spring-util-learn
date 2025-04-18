package org.example.learn.spring.util.basic.file;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Arrays;

public class ResourcePatternTest {

    @Test
    public void test0() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String userCodePackageNamePattern = ClassUtils.convertClassNameToResourcePath("org.example.learn.spring.util.basic");
        String searchUserCode = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + userCodePackageNamePattern + "/**/*.class";
        Resource[] resources = resourcePatternResolver.getResources(searchUserCode);
        Arrays.stream(resources).forEach(System.out::println);
    }
}
