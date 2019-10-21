package org.fasttrackit.todolist.domain.persistance;

import org.fasttrackit.todolist.transfer.CreateToDoItemRequest;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDoItemRepository {

    public void createToDoItem(CreateToDoItemRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "INSERT INTO to_do_item (description, deadline) VALUES (?,?)";
        //try with resources - closes all the resources in the end
        try (Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadline()));

            preparedStatement.executeUpdate();
        }

    }

    public void updateToDoItem(long id, boolean done) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE to_do_item SET done=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setBoolean(1, done);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();

        }
    }
    public void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM to_do_item WHERE id=?";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setLong(1,id);

                preparedStatement.executeUpdate();

        }
    }
}
