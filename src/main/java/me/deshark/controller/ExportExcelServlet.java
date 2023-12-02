package me.deshark.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.deshark.bean.UserBean;
import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/ExportExcelServlet")
public class ExportExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 获取学生数据，这里假设你有一个名为userService的UserService类用于处理用户数据
            UserDao userDao = new UserDaoImpl();
            List<UserBean> users = userDao.getAllUsers(); // 获取所有学生信息

            // 创建一个工作簿
            Workbook workbook = new XSSFWorkbook();
            // 创建一个工作表
            Sheet sheet = workbook.createSheet("学生信息表");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("学号");
            headerRow.createCell(1).setCellValue("邮箱");
            headerRow.createCell(2).setCellValue("姓名");
            headerRow.createCell(3).setCellValue("性别");
            headerRow.createCell(4).setCellValue("注册时间");

            // 填充数据
            int rowNum = 1;
            for (UserBean user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getUid());
                row.createCell(1).setCellValue(user.getEmail());
                row.createCell(2).setCellValue(user.getUsername());
                row.createCell(3).setCellValue(user.getSex());
                row.createCell(4).setCellValue(user.getRegister_at().toString());
                // 可根据需要添加其他列
            }
            // 设置服务器端文件路径，确保该路径存在
//            String serverFilePath = "D:\\Code\\IdeaProjects\\JavaWeb-Servlet\\out\\artifacts\\JavaWeb_Servlet_Web_exploded\\student_info.xlsx";
////            String serverFilePath = getServletContext().getRealPath("") + File.separator + "student_info.xlsx";
//            String serverFileDirPath = getServletContext().getRealPath("") + File.separator + "excel";
//            File uploadDir = new File(serverFileDirPath);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdir();
//            }
//
//            // 将工作簿写入服务器端文件
//            try (FileOutputStream fileOut = new FileOutputStream(serverFilePath)) {
//                workbook.write(fileOut);
//            }
//            // 关闭工作簿
//            workbook.close();
//
//            // 返回成功信息给客户端
//            resp.getWriter().write("导出成功");

        } catch (Exception e) {
            // 处理异常，可以返回错误信息给客户端
            resp.getWriter().write("导出失败");
            throw new RuntimeException(e);
        }
    }
}

//    public static void main(String[] args) {
//        //1、创建一个工作簿
//        Workbook workbook = new XSSFWorkbook();
//        //2、创建一个工作表
//        Sheet sheet = workbook.createSheet("表1");
//        //3、创建一个行（1，1）
//        Row row = sheet.createRow(0);
//        //4、创建一个单元格
//        Cell cell = row.createCell(0);
//        cell.setCellValue("数据");
//        //生成一张表
//        FileOutputStream outputStream = new FileOutputStream(Path + "test.xlsx");
//        //输出
//        try {
//            workbook.write(outputStream);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        //关闭流
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

