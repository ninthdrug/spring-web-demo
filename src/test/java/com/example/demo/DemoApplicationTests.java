package com.example.demo;

import com.example.demo.controllers.DemoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void isZipcode() {
        assert(DemoController.isZipcode(null) == false);
        assert(DemoController.isZipcode("") == false);
        assert(DemoController.isZipcode("123456") == false);
        assert(DemoController.isZipcode("ABCDE") == false);
        assert(DemoController.isZipcode("12345") == true);
    }
}

