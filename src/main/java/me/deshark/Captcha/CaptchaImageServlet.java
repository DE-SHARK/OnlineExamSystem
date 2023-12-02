package me.deshark.Captcha;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "CaptchaImageServlet", urlPatterns = "/CaptchaImageServlet")
public class CaptchaImageServlet extends HttpServlet {

    private static final int IMAGE_WIDTH = 150;
    private static final int IMAGE_HEIGHT = 50;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        // 获取验证码
        String captcha = CaptchaGenerator.generateCaptcha();

        // 上传验证码
        req.getSession().setAttribute("captcha", captcha);

        // 获取验证码
//            HttpSession session = req.getSession();
//            String captcha = (String) session.getAttribute("captcha");

        // 创建验证码图片
        BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // 设置图片颜色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        // 设置文件颜色
        g.setColor(Color.BLACK);

        // 设置字体样式
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        g.setFont(font);

        // 将验证码绘制在图片上
        g.drawString(captcha, 20, 30);

        // 结束绘制
        g.dispose();

        // 将图片写入响应输出流
        resp.setContentType("image/png");
        try {
            ImageIO.write(image, "png", resp.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}