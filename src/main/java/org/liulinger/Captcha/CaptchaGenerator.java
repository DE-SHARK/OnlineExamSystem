package org.liulinger.Captcha;

import java.util.Random;

public class CaptchaGenerator {
    private static final int CAPTCHA_LENGTH = 6; // 验证码长度
    private static final String CAPTCHA_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateCaptcha() {
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            int index = random.nextInt(CAPTCHA_CHARACTERS.length());
            captcha.append(CAPTCHA_CHARACTERS.charAt(index));
        }

        return captcha.toString();
    }
}
