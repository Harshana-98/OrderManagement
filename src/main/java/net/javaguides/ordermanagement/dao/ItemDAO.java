package net.javaguides.ordermanagement.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.javaguides.ordermanagement.common.SQLCommands;
import net.javaguides.ordermanagement.model.Item;
import net.javaguides.ordermanagement.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemDAO {

    @Getter
    public static final ItemDAO itemDao = new ItemDAO();

    public List<Item> selectAllItems() throws Throwable {
        Connection connection = DaoConnection.getDaoConnection().getConnection();
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection
                .prepareStatement(SQLCommands.SELECT_ALL_FOOD_ITEM.getSqlCommands())) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                items.add(new Item(
                        rs.getString("foodname"),
                        rs.getDouble("price"))
                );
            }
        }
        return items;
    }

}
