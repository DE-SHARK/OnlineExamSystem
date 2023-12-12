//package me.xizhehong.controller;
//
//import me.xizhehong.Bean.Student;
//import me.xizhehong.Service.UserMangeService;
//import me.xizhehong.Service.UserMangeService_impl;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/DownloadServlet")
//public class DownloadServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        UserMangeService userMangeService = new UserMangeService_impl();
//        List list = userMangeService.UserMange();
//
//        // 创建Excel文件
//        Workbook workbook = createExcel(list);
//
//        // 设置响应头，告诉浏览器这是一个Excel文件
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Disposition", "attachment; filename=student_data.xlsx");
//
//        // 将Excel写入响应输出流
//        workbook.write(response.getOutputStream());
//
//        // 关闭工作簿
//        workbook.close();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//
//    private Workbook createExcel(List<Student> studentList) {
//        Workbook workbook = new HSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Student Data");
//
//        // 创建标题行
//        Row headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("学生ID");
//        headerRow.createCell(1).setCellValue("用户名");
//        headerRow.createCell(2).setCellValue("学生姓名");
//        headerRow.createCell(4).setCellValue("学号");
//        headerRow.createCell(5).setCellValue("性别");
//        headerRow.createCell(6).setCellValue("专业");
//
//        int rowNum = 1;
//
//        for (Student student : studentList) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(student.getUid());
//            row.createCell(1).setCellValue(student.getUsername());
//            row.createCell(2).setCellValue(student.getRealname());
//            row.createCell(3).setCellValue(student.getUsernumber());
//            row.createCell(4).setCellValue(student.getSex());
//            row.createCell(5).setCellValue(student.getProfession());
//        }
//        return workbook;
//    }
//}
