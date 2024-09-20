package com.example.tarea3_20182693.model.repository;

import com.example.tarea3_20182693.model.bean.Department;
import com.example.tarea3_20182693.model.bean.Employee;
import com.example.tarea3_20182693.model.bean.Location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO extends BaseDAO {

    public ArrayList<Employee> findAll() {

        ArrayList<Employee> listaEmpleados = new ArrayList<>();

        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.email, "
                + "d.department_name, l.city "
                + "FROM employees e "
                + "JOIN departments d ON e.department_id = d.department_id "
                + "JOIN locations l ON d.location_id = l.location_id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));

                // Departamento
                Department department = new Department();
                department.setDepartName(rs.getString("department_name"));
                employee.setDepartment(department);

                // Ubicación
                Location location = new Location();
                location.setCity(rs.getString("city"));
                employee.setLocation(location);

                listaEmpleados.add(employee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEmpleados;
    }

    public Employee findById(int id) {

        Employee employee = new Employee();

        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.email, "
                + "d.department_name, l.city "
                + "FROM employees e "
                + "JOIN departments d ON e.department_id = d.department_id "
                + "JOIN locations l ON d.location_id = l.location_id "
                + "WHERE e.employee_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setEmail(rs.getString("email"));

                    Department department = new Department();
                    department.setDepartName(rs.getString("department_name"));
                    employee.setDepartment(department);

                    Location location = new Location();
                    location.setCity(rs.getString("city"));
                    employee.setLocation(location);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employee;
    }

    public boolean deleteById(int id) { /* popup hecho */
        String sql =  "DELETE FROM employees WHERE employee_id = ?";
        boolean flag = false;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                flag = true;  // Se eliminó correctamente
            }

        }  catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

}