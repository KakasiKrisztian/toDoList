package org.fasttrackit.todolist;

import org.fasttrackit.todolist.domain.persistance.ToDoItemRepository;
import org.fasttrackit.todolist.transfer.CreateToDoItemRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        CreateToDoItemRequest createToDoItemRequest = new CreateToDoItemRequest();
        createToDoItemRequest.setDescription("Learn JDBC");
        createToDoItemRequest.setDeadline(LocalDate.now().plusWeeks(1));
        ToDoItemRepository toDoItemRepository = new ToDoItemRepository();
        toDoItemRepository.createToDoItem(createToDoItemRequest);
    }
}
