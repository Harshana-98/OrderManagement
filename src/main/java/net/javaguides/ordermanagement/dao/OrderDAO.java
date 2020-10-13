package net.javaguides.ordermanagement.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.javaguides.ordermanagement.common.SQLCommands;
import net.javaguides.ordermanagement.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDAO {

    @Getter
    public static final OrderDAO orderDAO = new OrderDAO();

    public void insertOrder(Order order) throws Throwable {
        Connection connection = DaoConnection.getDaoConnection().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLCommands.INSERT_ORDER_SQL.getSqlCommands())) {
            preparedStatement.setString(1, order.getItemName());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.setInt(3, order.getQty());
            preparedStatement.setDouble(4, order.getSubTotal());
            preparedStatement.setDouble(5, order.getGrandTotal());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
    }

    public Order selectOrder(int id) throws Throwable {
        Connection connection = DaoConnection.getDaoConnection().getConnection();
        Order order = null;
        try (PreparedStatement preparedStatement = connection
                .prepareStatement(SQLCommands.SELECT_ORDER_BY_ID.getSqlCommands())) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                order = new Order(id,
                        rs.getString("itemName"),
                        rs.getDouble("price"),
                        rs.getInt("qty"),
                        rs.getDouble("subTotal"),
                        rs.getDouble("grandTotal"));
            }
        }

        return order;
    }

    public List<Order> selectAllOrder() throws Throwable {
        Connection connection = DaoConnection.getDaoConnection().getConnection();
        List<Order> order = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection
                .prepareStatement(SQLCommands.SELECT_ALL_ORDER.getSqlCommands())) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                order.add(new Order(
                        rs.getInt("id"),
                        rs.getString("itemName"),
                        rs.getDouble("price"),
                        rs.getInt("qty"),
                        rs.getDouble("subTotal"),
                        rs.getDouble("grandTotal")));
            }
        }
        return order;
    }

    public boolean deleteOrder(int id) throws Throwable {
        Connection connection = DaoConnection.getDaoConnection().getConnection();
        try (PreparedStatement statement = connection
                .prepareStatement(SQLCommands.DELETE_ORDER_SQL.getSqlCommands())) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    public boolean updateOrder(Order order) throws Throwable {
        Connection connection = DaoConnection.getDaoConnection().getConnection();
        try (PreparedStatement statement = connection
                .prepareStatement(SQLCommands.UPDATE_ORDER_SQL.getSqlCommands())) {
            statement.setString(1, order.getItemName());
            statement.setDouble(2, order.getPrice());
            statement.setInt(3, order.getQty());
            statement.setDouble(4, order.getSubTotal());
            statement.setDouble(5, order.getGrandTotal());
            statement.setInt(6, order.getId());
            return statement.executeUpdate() > 0;
        }
    }
}
