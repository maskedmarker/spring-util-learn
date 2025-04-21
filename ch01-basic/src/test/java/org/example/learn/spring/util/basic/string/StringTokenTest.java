package org.example.learn.spring.util.basic.string;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringTokenTest {

    @Test
    public void test01() {
        String str = "zhangsan lisi, wangwu";
        String[] tokens = StringUtils.tokenizeToStringArray(str, ",; \t\n");
        Arrays.stream(tokens).forEach(System.out::println);
    }
}
