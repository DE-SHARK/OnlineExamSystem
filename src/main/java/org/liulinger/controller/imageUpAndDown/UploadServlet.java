package org.liulinger.controller.imageUpAndDown;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;

@WebServlet("/student/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the uploaded file
        Part filePart = request.getPart("imageFile");

        // Get the file name
        String fileName = filePart.getSubmittedFileName();

        // Save the file to a specific location
        String savePath = "C:/Users/13159/Desktop/OnlineExamSystem/src/main/webapp/headImage/" + fileName;
//        String savePath = getServletContext().getRealPath("headImage") + File.separator + fileName;
        filePart.write(savePath);

        // Store the file path in a session or database for later retrieval
        // 保存文件路径到请求属性
        request.setAttribute("filePath", savePath);
//        request.getRequestDispatcher("studentInformation.jsp").forward(request, response);
        // Redirect back to the JSP page
        response.sendRedirect("GetStudentInformationServlet");

    }
}