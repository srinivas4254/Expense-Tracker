package com.expensetracker.dao;

import com.expensetracker.model.Expense;
import java.sql.*;
import java.util.*;

public class ExpenseDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/expense_tracker";
    private String jdbcUsername = "root";
    private String jdbcPassword = "tiger";

    private static final String INSERT_SQL = "INSERT INTO expenses (title, amount, category, date) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM expenses";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertExpense(Expense expense) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setString(4, expense.getDate());
            ps.executeUpdate();
        }
    }

    public List<Expense> listAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                e.setDate(rs.getString("date"));
                expenses.add(e);
            }
        }
        return expenses;
    }
}
