//package org.liulinger.controller.imageUpAndDown;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.*;
//
//@WebServlet("FileDownloadServlet")
//public class FileDownloadServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String fileName = request.getParameter("filename");
//
//        String filePath = getServletContext().getRealPath("/")+"downloads";
//
//        File file = new File(filePath);
//        if (file.exists()) {
//            response.setContentType("application/octet-stream");
//            response.setContentLength((int) file.length());
//            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//
//            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//                 BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
//                byte[] buffer = new byte[8192];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//            }
//        } else {
//            response.getWriter().println("文件不存在");
//        }
//    }
//}