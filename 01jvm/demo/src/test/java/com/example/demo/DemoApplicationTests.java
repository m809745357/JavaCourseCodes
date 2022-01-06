package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("Hello.xlass");

    }

}
