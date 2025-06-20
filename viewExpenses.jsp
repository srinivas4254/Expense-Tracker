<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.expensetracker.model.Expense" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Expenses</title>

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            margin: 40px;
            background-color: #f8f9fa;
        }

        .container {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            color: #343a40;
        }

        .back-link {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mb-4">All Expenses</h2>

    <%
        List<Expense> expenses = (List<Expense>) request.getAttribute("expenses");
        if (expenses != null && !expenses.isEmpty()) {
    %>
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Amount (₹)</th>
                    <th>Category</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
            <%
                for (Expense e : expenses) {
            %>
                <tr>
                    <td><%= e.getId() %></td>
                    <td><%= e.getTitle() %></td>
                    <td><%= e.getAmount() %></td>
                    <td><%= e.getCategory() %></td>
                    <td><%= e.getDate() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    <%
        } else {
    %>
        <div class="alert alert-warning">
            No expenses found.
        </div>
    <%
        }
    %>

<a href="<%= request.getContextPath() %>/index.html">← Back to Add Expense</a>


</div>

</body>
</html>
