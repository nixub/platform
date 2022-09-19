package com.yiliedu.platform;

import com.yiliedu.platform.service.KaptchaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlatformApplicationTests {
    @Autowired
    KaptchaService kaptchaService;

    @Test
    void contextLoads() throws Exception {
        System.out.println(kaptchaService.generateVerifyCode());
    }

}
