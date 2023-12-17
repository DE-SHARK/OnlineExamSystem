package org.liulinger.controller.imageUpAndDown;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;

@WebServlet("/ImageUploadServlet")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        // 获取上传的文件部分
        Part part = request.getPart("image");

        // 提取文件名
        String fileName = getFileName(part);

        //请在这里修改你的路径：

        String yourPath = "C:/Users/13159/Desktop/OnlineExamSystem/src/main/webapp/imageUploads/";
        // 保存文件的路径
//        String savePath = getServletContext().getRealPath("/")+"imageUploads"+ fileName;
        String savePath = yourPath + fileName;   //可行

        // 将文件保存到指定路径
        part.write(savePath);

        // 可以进行其他处理，例如保存文件路径到数据库等
        // 再刷新页面

        response.getWriter().println("Upload Success!");
    }

    // 从 Part 中提取文件名
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition"); //如果文件名提取不正确，将会导致保存文件时使用错误的文件名
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
    }
}
