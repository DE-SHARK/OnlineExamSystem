package org.liulinger.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/SendStudentAnswer")
public class SendStudentAnswer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionsLength = Integer.parseInt(request.getParameter("questionsLength"));

        // Loop through each group of radio buttons
        for (int i = 0; i < questionsLength; i++) {
            String selectedValue = request.getParameter("answer_" + i);
            System.out.println("Answer " + i + ": " + selectedValue);
        }
    }
}
