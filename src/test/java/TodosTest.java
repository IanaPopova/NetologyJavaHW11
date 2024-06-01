import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TodosTest {


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchSimpleTaskInTasksQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        String query = "Позвонить родителям";

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchMeetingInTasksQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        String query = "Приложение НетоБанка";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//
//    public void shouldSearchEpicInTasksQuery() {
//        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
//        Epic epic = new Epic(55, subtasks);
//
//        Todos todos = new Todos();
//        todos.add(epic);
//
//        String query = "Яйца";
//
//        Task[] expected = {epic};
//        Task[] actual = todos.search(query);
//
//        Assertions.assertArrayEquals(expected, actual);
//    }


}


