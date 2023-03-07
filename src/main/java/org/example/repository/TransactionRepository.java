package org.example.repository;


import org.example.db.DB;
import org.example.dto.Transaction_dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TransactionRepository {

    public int createTransaction(Transaction_dto transaction) {
        try (Connection connection = DB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into transaction(card_id,terminal_id,amount,type,created_date) " +
                            "values (?,?,?,?,?)");
            statement.setInt(1, transaction.getCardId());

            if (transaction.getTerminalId() != null) {
                statement.setInt(2, transaction.getTerminalId());
            } else {
                statement.setObject(2, null);
            }

            statement.setDouble(3, transaction.getAmount());
            statement.setString(4, transaction.getTransactionType().name());
            statement.setTimestamp(5, Timestamp.valueOf(transaction.getCreatedDate()));

            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }
}
