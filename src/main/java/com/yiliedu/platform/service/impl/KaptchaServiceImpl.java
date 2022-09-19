package com.yiliedu.platform.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yiliedu.platform.service.KaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


@Service
public class KaptchaServiceImpl implements KaptchaService {

    @Autowired
    DefaultKaptcha producer;

    @Override
    public Map<String, Object> generateVerifyCode() throws Exception {

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(text);

        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        Map<String, Object> map = new HashMap<>();
        String base64= encoder.encode(outputStream.toByteArray());
        String kaptchaBase64="data:image/jpeg;base64,"+base64.replaceAll("\r\n","");
        map.put("textCode", text);
        map.put("picCode", kaptchaBase64);
        return map;
    }
}