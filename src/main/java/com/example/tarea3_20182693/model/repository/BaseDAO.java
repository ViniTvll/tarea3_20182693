package com.example.tarea3_20182693.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDAO {

    public Connection conn;

    public BaseDAO() {
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr?serverTimezone=UTC&useSSL=false&publicKeyRetrieval=true";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, "Driver de MySQL no encontrado", ex);
        }

        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, "Error al conectar con la base de datos", ex);
        }
    }
}