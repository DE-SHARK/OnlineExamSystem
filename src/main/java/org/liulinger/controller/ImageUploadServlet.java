package org.liulinger.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.liulinger.Dao.Impl.StudentInformationDaoImpl;
import org.liulinger.Dao.StudentInformationDao;
import org.liulinger.Service.Impl.StudentInformationServiceImpl;
import org.liulinger.Service.StudentInformationService;

import java.io.*;

@WebServlet("/ImageUploadServlet")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {
    private StudentInformationService studentInformationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //注入依赖
        StudentInformationDao studentInformationDao = new StudentInformationDaoImpl();
        this.studentInformationService = new StudentInformationServiceImpl(studentInformationDao);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        HttpSession session =  request.getSession();
        String uid = (String) session.getAttribute("uid");

        // 获取上传的文件部分
        Part part = request.getPart("image");
        // 提取文件名
        String fileName = getFileName(part);

        //请在这里修改你的路径：
        String yourPath = "C:/Users/13159/Desktop/OnlineExamSystem/src/main/webapp/imageUploads/";
        // 保存文件的路径
        String savePath = yourPath + fileName;   //可行
        //String savePath = getServletContext().getRealPath("/")+"imageUploads"+ fileName;

        //将文件保存到数据库中
        String saveDataPath = "/imageUploads/"+fileName;
        System.out.println(saveDataPath);
        studentInformationService.updateAvatar_url(uid,saveDataPath);

//        // 自行判断文件是否已存在
//        File file = new File(savePath);
//        if (file.exists()) {
//            System.out.println("文件已存在。");
//            // 可以进行其他处理，例如重命名文件或直接返回错误信息
//            response.getWriter().println("Error: File already exists!");
//            return;
//        }

        // 将文件保存到指定路径
        try {
            part.write(savePath);
            System.out.println("写入文件成功。");
        } catch (java.io.IOException e) {
            System.out.println("写入文件失败，请检查路径或权限。");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("发生未知异常。");
            e.printStackTrace();
        }

        // 可以进行其他处理，例如保存文件路径到数据库等
        // 再刷新页面
        response.getWriter().println("Upload Success!");
        // 延迟2秒
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // 返回原页面
        response.sendRedirect("GetStudentInformationServlet");
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
