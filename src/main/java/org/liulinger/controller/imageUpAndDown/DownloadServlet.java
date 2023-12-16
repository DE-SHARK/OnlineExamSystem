package org.liulinger.controller.imageUpAndDown;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/student/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName"); // 获取要下载的文件名
        String filePath = "C:/Users/13159/Desktop/image/" + fileName; // 设置文件的完整路径

        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        // 设置响应内容类型
        String mimeType = getServletContext().getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);

        // 设置Content-Disposition，以便将文件下载到客户端
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;
        response.setHeader(headerKey, headerValue);

        // 将文件内容写入响应输出流
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = fis.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        fis.close();
        outStream.close();
    }
}