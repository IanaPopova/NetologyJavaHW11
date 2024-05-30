import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test

    public void getId() {
        Task task = new SimpleTask(5, "Позвонить родителям");

        int expected = 5;
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsSameTask() {
        Task task = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = task.equals(task);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldShowTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsDifferentTaskSameId() {
        Task task1 = new SimpleTask(5, "Позвонить родителям");
        Task task2 = new SimpleTask(5, "Позвонить сестре");

        boolean expected = true;
        boolean actual = task1.equals(task2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notEqualsDifferentTaskDifferentId() {
        Task task1 = new SimpleTask(5, "Позвонить родителям");
        Task task2 = new SimpleTask(6, "Позвонить сестре");

        boolean expected = false;
        boolean actual = task1.equals(task2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsNull() {
        Task task = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = task.equals(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void giveHash() {
        Task task1 = new SimpleTask(5, "Позвонить родителям");
        Task task2 = new SimpleTask(5, "Позвонить сестре");

        int expected = task1.hashCode();
        int actual = task2.hashCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldMatchSimpleTaskInQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String query = "Позвонить родителям";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchSimpleTaskInQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String query = "Поздняя ночь";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldMatchMeetingTopicInQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Выкатка 3й версии приложения";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldMatchMeetingProjectInQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Приложение НетоБанка";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldShowTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldShowProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();

        Assertions.assertEquals(expected, actual);
    }


    @Test

    public void shouldNotMatchMeetingTopicInQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Поздняя ночь";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchMeetingProjectInQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Поздняя ночь";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldShowSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldMatchEpicSubtaskInQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] query = {"Молоко", "Яйца", "Хлеб"};

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void shouldMatchEpicOneSubtaskInQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] query = {"Молоко"};

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldMatchEpicPartSubtaskInQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] query = {"Молоко", "Яйца"};

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldNotMatchEpicSubtaskInQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] query = {"Кофе", "Чай", "Печенье"};

        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}

