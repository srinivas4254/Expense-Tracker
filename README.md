
# 💸 Expense Tracker (Java, JSP, Servlets, MySQL)

This is a simple web-based Expense Tracker application built using Java (JSP + Servlets), MySQL, and Apache Tomcat. It allows users to **add expenses** and **view all expenses**.

---

## 🚀 Features Implemented

- ✅ Add a new expense (title, amount, category, date)
- ✅ View a list of all added expenses
- ✅ MySQL database integration
- ✅ Bootstrap-styled frontend (basic styling)


---

## 📁 Folder Structure

```
ExpenseTracker/
├── src/
│   └── com/expensetracker/
│       ├── controller/ExpenseServlet.java
│       ├── dao/ExpenseDAO.java
│       ├── model/Expense.java
│       └── util/DBUtil.java
├── webapp/
│   ├── index.jsp
│   ├── viewExpenses.jsp
│   └── WEB-INF/web.xml
├── pom.xml (if using Maven)
└── README.md
```

---

## 🛠️ How to Run the Project

### Prerequisites:
- Java JDK 8–17
- Apache Tomcat 9
- MySQL Database
- Eclipse IDE or VS Code with Java EE extensions

### Steps:
1. ✅ Clone the repository or copy the project into Eclipse/VS Code.
2. ✅ Ensure your MySQL DB is running and contains a database named: `expense_tracker`.
3. ✅ Create the following table in your DB:
   ```sql
   CREATE TABLE expenses (
     id INT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(100),
     amount DOUBLE,
     category VARCHAR(50),
     date VARCHAR(20)
   );
   ```
4. ✅ Configure your DB connection in `DBUtil.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
   private static final String USER = "root";
   private static final String PASSWORD = "tiger";
   ```

5. ✅ Deploy the project to Tomcat 9.
6. ✅ Visit `http://localhost:8090/ExpenseTracker/` in your browser.
7. ✅ Add and view expenses!

---

## 💡 Sample Input

### ➕ Add Expense Form:
- **Title**: Groceries  
- **Amount**: 250  
- **Category**: Food  
- **Date**: 2025-06-20  

### 🧾 View All Expenses:

| ID | Title     | Amount | Category | Date       |
|----|-----------|--------|----------|------------|
| 1  | Groceries | ₹250   | Food     | 2025-06-20 |

---

## 🧑‍💻 Author

- Penneru Naga Srinivas  
- Built with  Java + JSP + MySQL

---

