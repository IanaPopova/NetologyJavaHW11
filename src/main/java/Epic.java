public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.equals(query))
                return true;
        }
        return false;
    }
}

