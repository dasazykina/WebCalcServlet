package com.example.servletcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int numberOne  = Integer.parseInt(req.getParameter("num1"));
        int numberTwo = Integer.parseInt(req.getParameter("num2"));
        String operationType = req.getParameter("op");
        
        
        String message;
        int result;

        switch (operationType) {
            case "add":
                result = numberOne + numberTwo;
                message = "Result = %s".formatted(result);
                break;
            case "sub":
                result = numberOne - numberTwo;
                message = "Result = %s".formatted(result);
                break;
            case "mul":
                result = numberOne * numberTwo;
                message = "Result = %s".formatted(result);
                break;
            case "div":
                result = numberOne / numberTwo;
                message = "Result = %s".formatted(result);
                break;
            default:
                message = "Unknown operation";
                break;
        }

        PrintWriter writer = resp.getWriter();
        writer.print(message);

    }
}
