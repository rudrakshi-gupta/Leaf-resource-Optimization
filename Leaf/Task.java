public class Task implements Comparable<Task> {
    private int priority;
    private String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Task otherTask) {
        return Integer.compare(this.priority, otherTask.getPriority());
    }

    public void execute() {
        // Do something here to execute the task
    }
}
