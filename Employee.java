import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

// Conection
public class Employee {
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/empolyeeData";
        String user = "root";
        String password = "Prabhat@1234#";
        return DriverManager.getConnection(url, user, password);
    }

    public static int ide;

    public static void main(String[] args) {

        JFrame f = new JFrame("Employee Data Entry");

        JLabel ltag = new JLabel("Employee Data Entry");
        ltag.setBounds(90, 20, 300, 50);
        ltag.setFont(new Font("Arial", Font.BOLD, 24));
        f.add(ltag);

        JLabel lname = new JLabel("Name:");
        JLabel lemail = new JLabel("Email:");
        JLabel lnumber = new JLabel("Phone Number:");

        lname.setBounds(20, 80, 80, 20);
        lemail.setBounds(20, 200, 80, 20);
        lnumber.setBounds(20, 240, 210, 20);

        JTextField tname = new JTextField();
        JTextField temail = new JTextField();
        JTextField tnumber = new JTextField(Integer.BYTES);
        tname.setBounds(130, 80, 300, 35);
        temail.setBounds(130, 200, 300, 35);
        tnumber.setBounds(130, 240, 300, 35);
        // bob
        JLabel ldob = new JLabel("Enter DOB:");
        JLabel ldob2 = new JLabel("(yyyy-MM-dd)");
        f.add(ldob2);

        ldob.setBounds(20, 120, 210, 15);
        ldob2.setBounds(20, 140, 210, 15);

        JFormattedTextField tdob = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        tdob.setColumns(10);
        tdob.setBounds(130, 120, 300, 35);

        // gender

        JLabel lgender = new JLabel("Gender:");
        lgender.setBounds(20, 160, 210, 20);
        f.add(lgender);
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        male.setBounds(130, 160, 150, 35);
        female.setBounds(280, 160, 150, 35);

        ButtonGroup bgender = new ButtonGroup();
        bgender.add(male);
        bgender.add(female);
        f.add(male);
        f.add(female);

        // marital
        JLabel lmarital = new JLabel("Marital Status:");
        lmarital.setBounds(20, 280, 210, 20);
        f.add(lmarital);
        JRadioButton married = new JRadioButton("Married");
        JRadioButton unmarried = new JRadioButton("Unmarried");
        married.setBounds(130, 280, 150, 35);
        unmarried.setBounds(280, 280, 150, 35);

        ButtonGroup bmarital = new ButtonGroup();
        bmarital.add(married);
        bmarital.add(unmarried);
        f.add(married);
        f.add(unmarried);

        // Department
        String Dep[] = { "IT Department", "HR Department", "Accountent Department", "Mnagement Department", "Other" };
        JComboBox jdepartment = new JComboBox(Dep);
        JLabel ldepartment = new JLabel("Select Department:");
        ldepartment.setBounds(20, 320, 210, 20);
        jdepartment.setBounds(130, 320, 300, 35);
        f.add(ldepartment);
        f.add(jdepartment);
        // Salary
        JLabel lsalary = new JLabel("Salary:");
        lsalary.setBounds(20, 360, 210, 20);
        JTextField tsalary = new JTextField();
        tsalary.setBounds(130, 360, 300, 35);
        f.add(lsalary);
        f.add(tsalary);

        // Button save
        JButton save = new JButton("Save");
        save.setBounds(200, 400, 100, 35);
        f.add(save);
        // Search
        JButton search = new JButton("Search");
        search.setBounds(320, 400, 100, 35);
        f.add(search);
        // Clear
        JButton clear = new JButton("Clear");
        clear.setBounds(200, 440, 100, 35);
        f.add(clear);
        // add
        JButton add = new JButton("Add+");
        add.setBounds(80, 400, 100, 35);

        f.add(add);
        // updata
        JButton update = new JButton("Update");
        update.setBounds(200, 400, 100, 35);
        update.setVisible(false);
        f.add(update);

        JButton show = new JButton();
        show.setVisible(false);
        f.add(show);

        // Profile Panel
        JPanel profilePanel = new JPanel();
        profilePanel.setBounds(500, 30, 600, 420);
        profilePanel.setLayout(null);
        profilePanel.setBorder(BorderFactory.createTitledBorder("Profile Details"));

        // Profile Icon
        JLabel profileIcon = new JLabel();
        profileIcon.setBounds(290, 15, 50, 50);
        profileIcon.setIcon(new ImageIcon(new ImageIcon("pro.png").getImage()
                .getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        profilePanel.add(profileIcon);
        // profile logo
        JLabel profileIcon2 = new JLabel();
        profileIcon2.setBounds(30, 20, 100, 100);
        profileIcon2.setIcon(new ImageIcon(new ImageIcon("logo.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        profilePanel.add(profileIcon2);
        // neme
        JLabel pname = new JLabel("Prabhat Maurya");
        pname.setBounds(260, 60, 400, 35);
        pname.setFont(new Font("Arial", Font.TYPE1_FONT, 25));
        pname.setForeground(Color.gray);
        profilePanel.add(pname);
        // Button edit
        JButton edit = new JButton("Edit");
        edit.setBounds(470, 370, 70, 25);
        profilePanel.add(edit);
        edit.setForeground(Color.white);
        edit.setBackground(Color.lightGray);
        // Button Delete
        JButton delete = new JButton("Delete");
        delete.setBounds(380, 370, 70, 25);
        profilePanel.add(delete);
        delete.setForeground(Color.white);
        delete.setBackground(Color.red);
        // Radiobuttonstatus
        JRadioButton bactive = new JRadioButton("Active");
        JRadioButton binactive = new JRadioButton("Inactive");
        bactive.setBounds(400, 370, 90, 25);
        binactive.setBounds(500, 370, 90, 25);
        ButtonGroup bstatus = new ButtonGroup();
        bactive.setForeground(Color.green);
        binactive.setForeground(Color.red);

        bstatus.add(bactive);
        bstatus.add(binactive);
        profilePanel.add(bactive);
        profilePanel.add(binactive);
        bactive.setVisible(false);
        binactive.setVisible(false);

        // Labels for Details
        JLabel nameLabel = new JLabel("Name: ");
        JLabel statusLabel = new JLabel("Active");

        JLabel idLabel = new JLabel("Employee ID: ");
        JLabel genderLabel = new JLabel("Gender: ");
        JLabel dobLabel = new JLabel("DOB: ");
        JLabel maritalLabel = new JLabel("Marital Status: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel mobileLabel = new JLabel("Mobile: ");
        JLabel departmentLabel = new JLabel("Department: ");
        JLabel salaryLabel = new JLabel("Salary: ");

        // Positioning Labels
        statusLabel.setBounds(280, 80, 400, 35);
        int y = 140;
        int labelHeight = 25;
        nameLabel.setBounds(20, y, 400, labelHeight);
        idLabel.setBounds(20, y += 30, 400, labelHeight);

        genderLabel.setBounds(20, y += 30, 400, labelHeight);
        dobLabel.setBounds(20, y += 30, 400, labelHeight);
        maritalLabel.setBounds(20, y += 30, 400, labelHeight);
        emailLabel.setBounds(20, y += 30, 400, labelHeight);
        mobileLabel.setBounds(20, y += 30, 400, labelHeight);
        departmentLabel.setBounds(20, y += 30, 400, labelHeight);
        salaryLabel.setBounds(20, y += 30, 400, labelHeight);

        // Add Labels to Panel
        profilePanel.add(nameLabel);
        profilePanel.add(idLabel);
        profilePanel.add(genderLabel);
        profilePanel.add(dobLabel);
        profilePanel.add(maritalLabel);
        profilePanel.add(emailLabel);
        profilePanel.add(mobileLabel);
        profilePanel.add(departmentLabel);
        profilePanel.add(salaryLabel);
        profilePanel.add(statusLabel);

        profilePanel.setVisible(false);

        // Employee Table
        String[] columnNames = { "ID", "Name", "Gender", "DOB", "Email", "Phone", "Department", "Salary", "Status" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable employeeTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(employeeTable);
        tableScroll.setBounds(20, 500, 1200, 170);
        applyStatusColumnRenderer(employeeTable, 8);

        f.add(tableScroll);

        f.add(profilePanel);
        refreshTable(tableModel);
        f.add(lname);
        f.add(ldob);
        f.add(lnumber);
        f.add(lemail);
        f.add(tname);
        f.add(tnumber);
        f.add(tdob);
        f.add(temail);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1500, 900);
        f.setLayout(null);
        f.setVisible(true);

        // Backed code

        save.addActionListener(e -> {
            try (Connection conn = getConnection()) {
                String query = "INSERT INTO employee (name, gender, dob, marital_status, email, mobile, department, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);

                ps.setString(1, tname.getText());
                ps.setString(2, male.isSelected() ? "Male" : "Female");
                ps.setDate(3, Date.valueOf(tdob.getText()));
                ps.setString(4, married.isSelected() ? "Married" : "Unmarried");
                ps.setString(5, temail.getText());
                ps.setString(6, tnumber.getText());
                ps.setString(7, (String) jdepartment.getSelectedItem());
                ps.setDouble(8, Double.parseDouble(tsalary.getText()));

                ps.executeUpdate();
                JOptionPane.showMessageDialog(f, "Employee Saved!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
            }

            // show
            try {
                Connection conn = getConnection();
                String query = "SELECT * FROM employee\n" +
                        "ORDER BY id DESC\n" +
                        "LIMIT 1;";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                // profile show part
                if (rs.next()) {
                    // Update UI components
                    ide = rs.getInt("id");
                    String status = rs.getString("status");
                    if (status.equals("Active")) {
                        statusLabel.setForeground(Color.GREEN);
                    } else {
                        statusLabel.setForeground(Color.RED);

                    }
                    statusLabel.setText(status);
                    nameLabel.setText("Name: " + rs.getString("name"));
                    pname.setText(rs.getString("name"));
                    idLabel.setText("Employee ID: " + rs.getInt("id"));
                    genderLabel.setText("Gender: " + rs.getString("gender"));
                    dobLabel.setText("DOB: " + rs.getDate("dob").toString());
                    maritalLabel.setText("Marital Status: " + rs.getString("marital_status"));
                    emailLabel.setText("Email: " + rs.getString("email"));
                    mobileLabel.setText("Mobile: " + rs.getString("mobile"));
                    departmentLabel.setText("Department: " + rs.getString("department"));
                    salaryLabel.setText("Salary: " + rs.getDouble("salary"));
                    profilePanel.setVisible(true);
                    clear.doClick();
                    refreshTable(tableModel);

                } else {
                    JOptionPane.showMessageDialog(f, "Empolyee Not found");

                }
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(f, "Database error: " + e1.getMessage());
            }

        });

        clear.addActionListener(e -> {
            tname.setText("");
            temail.setText("");
            tnumber.setText("");
            tdob.setText("");
            bgender.clearSelection();
            bmarital.clearSelection();
            jdepartment.setSelectedIndex(0);
            tsalary.setText("");
        });

        search.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(f, "Enter Employee ID:");
            try (Connection conn = getConnection()) {
                String query = "SELECT * FROM employee WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(id));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Update UI components
                    ide = rs.getInt("id");
                    String status = rs.getString("status");
                    if (status.equals("Active")) {
                        statusLabel.setForeground(Color.GREEN);
                    } else {
                        statusLabel.setForeground(Color.RED);

                    }
                    statusLabel.setText(status);
                    nameLabel.setText("Name: " + rs.getString("name"));
                    pname.setText(rs.getString("name"));
                    idLabel.setText("Employee ID: " + rs.getInt("id"));
                    genderLabel.setText("Gender: " + rs.getString("gender"));
                    dobLabel.setText("DOB: " + rs.getDate("dob").toString());
                    maritalLabel.setText("Marital Status: " + rs.getString("marital_status"));
                    emailLabel.setText("Email: " + rs.getString("email"));
                    mobileLabel.setText("Mobile: " + rs.getString("mobile"));
                    departmentLabel.setText("Department: " + rs.getString("department"));
                    salaryLabel.setText("Salary: " + rs.getDouble("salary"));
                    profilePanel.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(f, "Empolyee Not found");

                }

                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(f, "Database error: " + e1.getMessage());
            }
        });

        update.addActionListener(e -> {

            try (Connection conn = getConnection()) {
                String query = "UPDATE employee SET name = ?, gender = ?, dob = ?, marital_status = ?, email = ?, mobile = ?, department = ?, salary = ?, status = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);

                ps.setString(1, tname.getText());
                ps.setString(2, male.isSelected() ? "Male" : "Female");
                ps.setDate(3, Date.valueOf(tdob.getText()));
                ps.setString(4, married.isSelected() ? "Married" : "Unmarried");
                ps.setString(5, temail.getText());
                ps.setString(6, tnumber.getText());
                ps.setString(7, (String) jdepartment.getSelectedItem());
                ps.setDouble(8, Double.parseDouble(tsalary.getText()));
                ps.setString(9, bactive.isSelected() ? "Active" : "Inactive");

                ps.setInt(10, ide);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(f, "Employee Updated!");
                update.setVisible(false);
                save.setVisible(true);
                show.doClick();
                bactive.setVisible(false);
                binactive.setVisible(false);
                edit.setVisible(true);
            delete.setVisible(true);

                clear.doClick();
                refreshTable(tableModel);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
            }
        });

        // Add button
        add.addActionListener(e -> {
            profilePanel.setVisible(false);

            save.setVisible(true);
            update.setVisible(false);
            bactive.setVisible(false);
            binactive.setVisible(false);
            edit.setVisible(true);
            delete.setVisible(true);
            refreshTable(tableModel);

        });

        // Edit button
        edit.addActionListener(e -> {
            delete.setVisible(false);
            edit.setVisible(false);
            save.setVisible(false);
            update.setVisible(true);
            bactive.setVisible(true);
            binactive.setVisible(true);

            try (Connection conn = getConnection()) {
                String query = "SELECT * FROM employee WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, ide);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tname.setText(rs.getString("name"));
                    temail.setText(rs.getString("email"));
                    tnumber.setText(rs.getString("mobile"));
                    tdob.setText(rs.getDate("dob").toString());
                    if ("Male".equals(rs.getString("gender"))) {
                        male.setSelected(true);
                    } else {
                        female.setSelected(true);
                    }
                    if ("Married".equals(rs.getString("marital_status"))) {
                        married.setSelected(true);
                    } else {
                        unmarried.setSelected(true);
                    }
                    if ("Active".equals(rs.getString("status"))) {
                        bactive.setSelected(true);
                    } else {
                        binactive.setSelected(true);
                    }
                    jdepartment.setSelectedItem(rs.getString("department"));
                    tsalary.setText(String.valueOf(rs.getDouble("salary")));
                } else {
                    JOptionPane.showMessageDialog(f, "Employee not found!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
            }

        });

        // Delete button
        delete.addActionListener(e -> {
            try (Connection conn = getConnection()) {
                String query = "DELETE FROM employee WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, ide);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(f, "Employee Deleted!");
                    refreshTable(tableModel);  
                    profilePanel.setVisible(false);  
                } else {
                    JOptionPane.showMessageDialog(f, "Employee not found!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
            }
        });
        
        // hide show button
        show.addActionListener(e -> {

            try (Connection conn = getConnection()) {
                String query = "SELECT * FROM employee WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, ide);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // Update UI components
                    ide = rs.getInt("id");
                    String status = rs.getString("status");
                    if (status.equals("Active")) {
                        statusLabel.setForeground(Color.GREEN);
                    } else {
                        statusLabel.setForeground(Color.RED);

                    }
                    statusLabel.setText(status);
                    nameLabel.setText("Name: " + rs.getString("name"));
                    pname.setText(rs.getString("name"));
                    idLabel.setText("Employee ID: " + rs.getInt("id"));
                    genderLabel.setText("Gender: " + rs.getString("gender"));
                    dobLabel.setText("DOB: " + rs.getDate("dob").toString());
                    maritalLabel.setText("Marital Status: " + rs.getString("marital_status"));
                    emailLabel.setText("Email: " + rs.getString("email"));
                    mobileLabel.setText("Mobile: " + rs.getString("mobile"));
                    departmentLabel.setText("Department: " + rs.getString("department"));
                    salaryLabel.setText("Salary: " + rs.getDouble("salary"));
                    profilePanel.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(f, "Empolyee Not found");

                }

                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(f, "Database error: " + e1.getMessage());
            }
        });

        employeeTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Get the clicked row and column
                int row = employeeTable.rowAtPoint(e.getPoint());
                int column = employeeTable.columnAtPoint(e.getPoint());
                if (column != 0) {

                    Object idValue = employeeTable.getValueAt(row, 0);
                    ide = ((Integer) idValue).intValue();

                    show.doClick();

                }
            }
        });

    }

    // Refresh Table

    private static void refreshTable(DefaultTableModel model) {
        model.setRowCount(0); // Clear existing rows
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Add rows to the model
            while (rs.next()) {
                Object[] row = {
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("dob"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("status")
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error refreshing table: " + ex.getMessage());
        }
    }

    public static void applyStatusColumnRenderer(JTable table, int columnIndex) {
        DefaultTableCellRenderer statusRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Apply custom text color based on the status value
                if (value != null && value.toString().equalsIgnoreCase("Active")) {
                    cell.setForeground(Color.GREEN);
                } else if (value != null && value.toString().equalsIgnoreCase("Inactive")) {
                    cell.setForeground(Color.RED);
                } else {
                    cell.setForeground(Color.BLACK);
                }

                return cell;
            }
        };

        // Set custom renderer to the specified column
        table.getColumnModel().getColumn(columnIndex).setCellRenderer(statusRenderer);
    }

}
