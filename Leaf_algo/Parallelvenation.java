import java.util.PriorityQueue;

public class Parallelvenation {
    private PriorityQueue<Task> taskQueue;

    public Parallelvenation() {
        taskQueue = new PriorityQueue<>();
    }

    public void addTask(Task task) {
        taskQueue.add(task);
    }

    public void executeTasks() {
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.poll();
            currentTask.execute();
        }
    }
}
