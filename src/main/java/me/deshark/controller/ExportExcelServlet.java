//package me.deshark.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import me.deshark.bean.UserBean;
//import me.deshark.dao.UserDao;
//import me.deshark.dao.impl.UserDaoImpl;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
//@WebServlet("/ExportExcelServlet")
//public class ExportExcelServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        // 获取学生数据
//        UserDao userDao = new UserDaoImpl();
//        List<UserBean> users = userDao.getAllUsers(); // 获取所有学生信息
//
//        // 创建一个工作簿
//        Workbook workbook = new XSSFWorkbook();
//        // 创建一个工作表
//        Sheet sheet = workbook.createSheet("学生信息表");
//
//        // 创建表头
//        Row headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("学号");
//        headerRow.createCell(1).setCellValue("邮箱");
//        headerRow.createCell(2).setCellValue("姓名");
//        headerRow.createCell(3).setCellValue("性别");
//        headerRow.createCell(4).setCellValue("注册时间");
//
//        // 填充数据
//        int rowNum = 1;
//        for (UserBean user : users) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(user.getUid());
//            row.createCell(1).setCellValue(user.getEmail());
//            row.createCell(2).setCellValue(user.getUsername());
//            row.createCell(3).setCellValue(user.getSex());
//            row.createCell(4).setCellValue(user.getRegister_at());
//        }
//
//        String filePath = getServletContext().getRealPath("") + File.separator + "User_Data.xlsx";
////        String filePath = "D:" + File.separator + "User_Data.xlsx";
//        // 将工作簿写入服务器端文件
//        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
//            workbook.write(outputStream);
//        }
//
//        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        resp.setHeader("Content-Disposition", "attachment; filename=User_Data.xlsx");
//        resp.setHeader("Content-Length", String.valueOf(new File(filePath).length()));
//        Files.copy(Paths.get(filePath), resp.getOutputStream());
//
//        // 关闭工作簿
//        workbook.close();
//
//    }
//}
