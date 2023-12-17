//package org.liulinger.controller.imageUpAndDown;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.Part;
//
//import java.io.File;
//import java.io.IOException;
//
//@WebServlet("/UpdateAvatarServlet")
//public class UpdateAvatarServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String savePath = getServletContext().getRealPath("/")+"imageUploads"; // 设置文件保存路径
//        File fileSaveDir = new File(savePath);
//        if (!fileSaveDir.exists()) {
//            fileSaveDir.mkdir();
//        }
//
//        Part part = request.getPart("newAvatar"); // 获取上传的新头像文件部分
//        String fileName = extractFileName(part); // 提取文件名
//
//        String filePath = savePath + File.separator + fileName;
//        part.write(filePath); // 保存新头像文件到指定路径
//
//        // 进行头像更新的其他逻辑，例如更新数据库等
//
//        response.getWriter().println("头像更新成功");
//    }
//
//    // 从 Part 中提取文件名
//    private String extractFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String item : items) {
//            if (item.trim().startsWith("filename")) {
//                return item.substring(item.indexOf("=") + 2, item.length() - 1);
//            }
//        }
//        return "";
//    }
//}