package com.expensetracker.controller;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.model.Expense;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/expense")
public class ExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ExpenseDAO expenseDAO;

    public void init() {
        expenseDAO = new ExpenseDAO();
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
           
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String date = request.getParameter("date");
            double amount = Double.parseDouble(request.getParameter("amount"));

         
            System.out.println("==== Form Submitted ====");
            System.out.println("Title: " + title);
            System.out.println("Amount: " + amount);
            System.out.println("Category: " + category);
            System.out.println("Date: " + date);

    
            Expense expense = new Expense();
            expense.setTitle(title);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setDate(date);

      
            expenseDAO.insertExpense(expense);

            System.out.println("✅ Expense inserted successfully");

        
            response.sendRedirect("expense");

        } catch (Exception e) {
         
            e.printStackTrace();

       
            response.getWriter().write("❌ Error: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Expense> expenses = expenseDAO.listAllExpenses();
            request.setAttribute("expenses", expenses);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpenses.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
