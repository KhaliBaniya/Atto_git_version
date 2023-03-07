package org.example.repository;


import org.example.db.DB;
import org.example.dto.Terminal_dto;
import org.example.enums.GeneralStatus;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TerminalRepository {

    public int save(Terminal_dto terminal) {
        Connection connection = DB.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into terminal(code,address,created_date,status) " +
                            "values (?,?,?,?)");
            statement.setString(1, terminal.getCode());
            statement.setString(2, terminal.getAddress());
            statement.setTimestamp(3, Timestamp.valueOf(terminal.getCreatedDate()));
            statement.setString(4, terminal.getStatus().name());

            int resultSet = statement.executeUpdate();
            return resultSet;


        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;

    }

    public Terminal_dto getTerminalByCode(String code) {
        try (Connection connection = DB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from terminal where visible = true and code=?");
            statement.setString(1, code);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Terminal_dto terminal = new Terminal_dto();

                terminal.setId(resultSet.getInt("id"));
                terminal.setCode(resultSet.getString("code"));
                terminal.setAddress(resultSet.getString("address"));
                terminal.setStatus(GeneralStatus.valueOf(resultSet.getString("status")));
                terminal.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                return terminal;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return null;
    }

    public List<Terminal_dto> getTerminalList() {

        Connection connection = DB.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from terminal where visible = true ");


            ResultSet resultSet = statement.executeQuery();

            List<Terminal_dto> terminals = new LinkedList<>();
            while (resultSet.next()) {
                Terminal_dto terminal = new Terminal_dto();

                terminal.setId(resultSet.getInt("id"));
                terminal.setCode(resultSet.getString("code"));
                terminal.setAddress(resultSet.getString("address"));
                terminal.setStatus(GeneralStatus.valueOf(resultSet.getString("status")));
                terminal.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                terminals.add(terminal);
            }

            return terminals;

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        return null;
    }

    public int updateTerminal(Terminal_dto terminal) {

        try (Connection connection = DB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update terminal set address=? where code=? ;");
            statement.setString(1, terminal.getAddress());
            statement.setString(2, terminal.getCode());

            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int changeTerminalStatus(String code, GeneralStatus status) {
        try (Connection connection = DB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update terminal set status=? where code=? ;");
            statement.setString(1, status.name());
            statement.setString(2, code);
            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return 0;
    }

    public int deleteTerminal(String code) {

        try (Connection connection = DB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update terminal set visible=false where code=? ;");

            statement.setString(1, code);

            int resultSet = statement.executeUpdate();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return 0;
    }
}
