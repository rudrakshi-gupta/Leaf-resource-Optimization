import java.util.Random;
import java.util.PriorityQueue;

public class  Parallelvenation{
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

    public static void main(String[] args) {
        Parallelvenation manager = new Parallelvenation();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int priority = rand.nextInt(10);
            String description = "Task " + i;
            Task task = new Task(priority, description);
            manager.addTask(task);
        }

        manager.executeTasks();
    }
}
