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
    public void shouldAddOneTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTwoTasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNoTasks() {
        Todos todos = new Todos();

        Task[] expected = {};
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

    public void shouldSearchMeetingInTasksOneWordQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        String query = "Приложение";

        Task[] expected = {meeting};
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

    @Test

    public void shouldSearchEpicTwoInTasksQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        String query = "Яйца";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchEpicThirdInTasksQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        String query = "Хлеб";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchEpicOneInTasksQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        String query = "Молоко";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchSimpleTaskWithOneWordInTasksQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        String query = "Позвонить";

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchMeetingTopicInTasksQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        String query = "Выкатка 3й версии приложения";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotSearchSimpleTaskInTasksQueryIfWrongRequest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        String query = "793842-0)%#^*)($";

        Task[] expected = {};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchMultipleTasksInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        String query = "риложен";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotSearchAnything() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        String query = "Здесь ничего нет";

        Task[] expected = {};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

}


