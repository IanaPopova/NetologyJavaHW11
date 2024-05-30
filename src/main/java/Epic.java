public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public boolean matches(String[] query) {
        for (String subtask : subtasks) {
            for (String q : query) {
                if (subtask.equals(q)) {
                    return true;
                }
            }
        }
        return false;
    }
}
