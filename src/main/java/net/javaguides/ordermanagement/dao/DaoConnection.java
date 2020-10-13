package net.javaguides.ordermanagement.dao;

import lombok.Getter;
import net.javaguides.ordermanagement.model.OrderManagementException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection {

    @Getter
    private final static DaoConnection daoConnection = new DaoConnection();

    @Getter
    private final Connection connection;

    private DaoConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/resturantsystem?useSSL=false";
            String JDBC_USERNAME = "root";
            String JDBC_PASSWORD = "";
            connection = DriverManager.getConnection(JDBC_CONNECTION, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new OrderManagementException("Error connecting to the database", e);
        }
    }
}
