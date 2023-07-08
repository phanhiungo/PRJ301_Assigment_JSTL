/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import anhddp.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author moneymaker
 */
public class ProductDAO {
    private final String CHECK_OUT = "INSERT INTO CheckoutInfo (CustomerFullName, ItemID, ItemName, Quantity, TotalPrice) VALUES (?, ?, ?, ?, ?)";
    public void saveCheckoutInfo(String customerFullName, String itemID, String itemName, int quantity, double totalPrice) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBHelper.getConnection();
            statement = connection.prepareStatement(CHECK_OUT);

            statement.setString(1, customerFullName);
            statement.setString(2, itemID);
            statement.setString(3, itemName);
            statement.setInt(4, quantity);
            statement.setDouble(5, totalPrice);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related errors
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
