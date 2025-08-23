package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Employee;
import com.project.utils.Constants;
import com.project.utils.DBConnection;

public class EmployeeDao {

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.GET_ALL_EMPLOYEES);
             ResultSet resultset = statement.executeQuery()) {

            while (resultset.next()) {
                int empId = resultset.getInt("empId");
                String name = resultset.getString("name");
                String email = resultset.getString("email");
                String phoneNum = resultset.getString("phone_number");
                int age = resultset.getInt("age");
                double salary = resultset.getDouble("salary");

                Employee emp = new Employee(empId, name, age, email, phoneNum, salary);
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void addEmployee(Employee employee) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SAVE_EMPLOYEE)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhoneNum());
            statement.setInt(4, employee.getAge());
            statement.setDouble(5, employee.getSalary());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(int empId) {
        Employee emp = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.GET_EMPLOYEE)) {

            statement.setInt(1, empId);
            ResultSet resultset = statement.executeQuery();

            if (resultset.next()) {
                String name = resultset.getString("name");
                String email = resultset.getString("email");
                String phoneNum = resultset.getString("phone_number");
                int age = resultset.getInt("age");
                double salary = resultset.getDouble("salary");

                emp = new Employee(empId, name, age, email, phoneNum, salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    public void updateEmployee(Employee employee) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhoneNum());
            statement.setInt(4, employee.getAge());
            statement.setDouble(5, employee.getSalary());
            statement.setInt(6, employee.getEmpId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
