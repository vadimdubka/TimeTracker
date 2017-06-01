package logic;// Created by sky-vd on 24.03.2017.

// позволяет добавить, удалить или изменить информацию о работниках

import entity.Employee;
import system.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class EmplManagSystem {
    private static EmplManagSystem instanse;
    private Connection connection; // почему не статик? потому что внутреннее поле объекта синглтона
    private ArrayList<Employee> employees;

    private EmplManagSystem() {
        connection = DBConnection.getConnection();
        loadEmployeesFromDB();
    }

    // + получение синглтона класса
    public static synchronized EmplManagSystem getInstance() {
        if (instanse == null) {
            instanse = new EmplManagSystem();
        }
        return instanse;
    }

    // + загрузка списка всех работников из БД
    public void loadEmployeesFromDB() {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        } else employees.clear();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employees ORDER BY empl_id");
            while (rs.next()) {
                Employee employee = new Employee(rs);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // + Получить список всех работников
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // + Получить работника из БД по его ID
    public Employee getEmployee(String empl_id) {
        Employee employee = null;
        PreparedStatement stm = null;
        int id = 0;
        try {
            id = Integer.parseInt(empl_id);
            stm = connection.prepareStatement("SELECT * FROM employees WHERE empl_id=?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return employee = new Employee(rs);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    // + Добавить работника в БД по его ID
    public void insertEmployeeInDB(Employee employee) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT INTO employees (surName, firstName, patronymic, dateOfBirth,sex, email, phone, post, wageRate, login, password)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, employee.getSurName());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getPatronymic());
            stmt.setDate(4, new Date(employee.getDateOfBirth().getTime()));
            stmt.setString(5, employee.getSex());
            stmt.setString(6, employee.getEmail());
            stmt.setString(7, employee.getPhone());
            stmt.setString(8, employee.getPost());
            stmt.setFloat(9, employee.getWageRate());
            stmt.setString(10, employee.getLogin());
            stmt.setString(11, employee.getPassword());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // + Удалить работника в БД по его ID
    public void deleteEmployeeInDB(Employee employee) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM employees WHERE empl_id=?");

            stmt.setInt(1, employee.getEmpl_id());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // + Обновить данные о работнике в БД по его ID
    public void updateEmployeeInDB(Employee employee) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE employees SET surName=?, firstName=?, patronymic=?, dateOfBirth=?,sex=?, email=?, phone=?, post=?, wageRate=?, login=?, password=? WHERE empl_id=?");

            stmt.setString(1, employee.getSurName());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getPatronymic());
            stmt.setDate(4, new Date(employee.getDateOfBirth().getTime()));
            stmt.setString(5, employee.getSex());
            stmt.setString(6, employee.getEmail());
            stmt.setString(7, employee.getPhone());
            stmt.setString(8, employee.getPost());
            stmt.setFloat(9, employee.getWageRate());
            stmt.setString(10, employee.getLogin());
            stmt.setString(11, employee.getPassword());
            stmt.setInt(12, employee.getEmpl_id());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
