# Employee Management System

This project is an **Employee Management System** that allows users to perform CRUD (Create, Read, Update, Delete) operations on employee data. The application is developed in **Java Swing** for the GUI and uses **MySQL** as the backend database. It is designed as an internship assignment project for Computer Science second-year students.

## Features
- Add new employees with details such as name, gender, DOB, marital status, email, phone number, department, and salary.
- Search for employees by their ID.
- Update existing employee information.
- Delete employee records.
- View all employee data in a table.
- Profile panel with detailed employee information.
- Active/Inactive status display.

## Technologies Used
- **Java** (JDK 11 or higher)
- **MySQL** (version 5.7 or higher recommended)
- **JDBC** (Java Database Connectivity)
- **Swing** (for GUI)

---

## Prerequisites
### Tools and Dependencies:
1. **Java Development Kit (JDK):** Ensure JDK 11 or higher is installed.
2. **MySQL Server:** Set up a MySQL server instance.
3. **MySQL Connector for Java:** Ensure the MySQL JDBC driver (e.g., `mysql-connector-java-8.x.x.jar`) is added to your project's classpath.
4. **IDE:** Use any Java IDE like IntelliJ IDEA, Eclipse, or NetBeans.
5. **Git:** For version control if needed.

---

## Setup Instructions

### 1. Database Setup:
1. Open your MySQL client (e.g., MySQL Workbench or command-line client).
2. Create a database named `employeeData`:
   ```sql
   CREATE DATABASE employeeData;
   ```
3. Switch to the newly created database:
   ```sql
   USE employeeData;
   ```
4. Create the `employee` table:
   ```sql
   CREATE TABLE employee (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       gender VARCHAR(10),
       dob DATE,
       marital_status VARCHAR(20),
       email VARCHAR(100),
       mobile VARCHAR(15),
       department VARCHAR(50),
       salary DOUBLE,
       status VARCHAR(10) DEFAULT 'Active'
   );
   ```

### 2. Project Configuration:
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in your IDE.
3. Add the MySQL Connector JAR file to your project:
   - In IntelliJ IDEA: Go to **File > Project Structure > Libraries** and add the JAR.
   - In Eclipse: Right-click on the project, go to **Build Path > Configure Build Path**, and add the JAR.

### 3. Update Database Connection:
In the code, locate the `getConnection()` method and update the following fields:
```java
String url = "jdbc:mysql://localhost:3306/employeeData"; // Update with your database host/port
String user = "root"; // Update with your MySQL username
String password = "Prabhat@1234#"; // Update with your MySQL password
```

### 4. Run the Application:
1. Compile and run the `Employee` class.
2. The application window should appear.
3. Use the GUI to interact with the database:
   - Add employee details using the **Save** button.
   - Search for employees using the **Search** button.
   - Update employee details via the **Edit** and **Update** buttons.
   - Delete employee records using the **Delete** button.

---

## Usage Instructions
1. **Add New Employee:**
   - Fill in all the employee details and click **Save**.
   - The record will be saved to the database.

2. **Search Employee:**
   - Click **Search** and enter the employee ID.
   - The profile panel will display the details of the employee if found.

3. **Update Employee:**
   - Search for an employee and click **Edit**.
   - Update the details and click **Update** to save changes.

4. **Delete Employee:**
   - Search for an employee and click **Delete** to remove the record.

5. **View All Employees:**
   - All employee records are displayed in the table at the bottom of the window.

---

## Common Errors and Fixes
1. **`No suitable driver found for jdbc:mysql://localhost:3306/employeeData`**:
   - Ensure the MySQL Connector JAR is added to your project classpath.

2. **`Access denied for user 'root'@'localhost'`**:
   - Check your MySQL username and password in the `getConnection()` method.

3. **Table not found:**
   - Ensure the database and table are correctly created.

---

## GitHub Repository Structure
- `src/`: Contains all Java source files.
- `README.md`: Project documentation.
- `lib/`: Contains external dependencies like the MySQL Connector JAR.
- `resources/`: Icons or additional resources for the GUI.

---

## Screenshots
1. **Main Application Window:**
   Displays the form to add/edit employees.
   ![Main Window](Screenshots/Screenshot_Main_Aplication_Windo.jpg)

2. **Profile Panel:**
   Shows detailed information about a specific employee.
   ![Profile Panel](Screenshots/Screenshot_Profile_Panal.jpg)

3. **Employee Table:**
   Displays all employee records with color-coded status.
   ![Employee Table](Screenshots/Screenshot_Employee_Table.jpg)
4. **Main Editable Application Window:**
   Displays the form whin click edit button  employees.
   ![Main Editable Window](Screenshots/Screenshot_Main_Edit_Frame_Windo.jpg)

---

## License
This project is distributed under the MIT License.

---

## Contributors
1. **Prabhat Maurya**

Feel free to report any issues or suggest improvements by creating a GitHub issue.
