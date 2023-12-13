package me.xizhehong.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/xizhehong/AuthCode")
public class AuthCode extends HttpServlet {
    public AuthCode() {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        //把验证码放入session
        String yanzhengma = product_yanzhengma();
        request.getSession().setAttribute("yanzhengma",yanzhengma);

        //将验证码生成的图片放入session
        BufferedImage image = product_image(yanzhengma);
//        request.getSession().setAttribute("image",image);

        response.setContentType("image/png");

        ImageIO.write(image, "png", response.getOutputStream());

    }

    public String product_yanzhengma() {
        // 生成随机验证码
        int length = 4;
        String characters = "0123456789";
        StringBuilder captchaCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            captchaCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        String yanzhengma = captchaCode.toString();
        return yanzhengma;
    }

    public BufferedImage product_image(String yanzhengma){
        // 创建验证码图片
        int width = 200;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // 设置背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 设置字体和颜色
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.BLACK);

        // 将验证码绘制到图片上
        g.drawString(yanzhengma, 20, 30);

        return image;
    }
}

