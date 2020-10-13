package net.javaguides.ordermanagement.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SQLCommands {
    INSERT_ORDER_SQL("INSERT INTO `order` (itemName, price, qty, subTotal, grandTotal)  VALUES  (?, ?, ?, ?, ?);"),
    SELECT_ORDER_BY_ID("select id, itemName, price, qty, subTotal, grandTotal from `order` where id =?"),
    SELECT_ALL_ORDER("select * from `order`"),
    DELETE_ORDER_SQL("delete from `order` where id = ?;"),
    UPDATE_ORDER_SQL("update order set (itemName = ?, price = ?, qty = ?, subTotal = ?, grandTotal = ? where id = ?);"),
    SELECT_ALL_FOOD_ITEM("select * from `fooditem`");
    String sqlCommands;
}
