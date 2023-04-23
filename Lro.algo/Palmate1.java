import java.util.*;

public class Palmate1 {
    public static void main(String[] args) {
        // Create a list of tasks with different priorities and bursts
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Task 1", 3, 5));
        taskList.add(new Task("Task 2", 1, 2));
        taskList.add(new Task("Task 3", 2, 4));
        taskList.add(new Task("Task 4", 4, 3));

        // Create a priority queue to store the tasks in the order they should be processed
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                if (task1.getPriority() > task2.getPriority()) {
                    return -1; // Higher priority
                } else if (task1.getPriority() < task2.getPriority()) {
                    return 1; // Lower priority
                } else {
                    return 0; // Same priority
                }
            }
        });

        // Add the tasks to the queue
        taskQueue.addAll(taskList);

        // Process the tasks in order of priority and burst time
        int currentTime = 0;
        Task currentTask = null;
        while (!taskQueue.isEmpty()) {
            // Get the task with the highest priority and the shortest burst time
            currentTask = taskQueue.poll();

            // Execute the task for 1 time unit
            currentTask.execute();

            // Increment the current time
            currentTime++;

            // Check if the task is completed
            if (currentTask.isCompleted()) {
                System.out.println("Task completed: " + currentTask.getName());
            } else {
                // Add the task back to the queue with updated priority and burst time
                currentTask.updatePriority();
                taskQueue.add(currentTask);
            }
        }
    }
}

class Task {
    private String name;
    private int priority;
    private int burstTime;
    private int remainingTime;

    public Task(String name, int priority, int burstTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    // Execute the task for 1 time unit
    public void execute() {
        System.out.println("Executing task: " + name + ", remaining time: " + remainingTime);
        remainingTime--;
    }

    // Check if the task is completed
    public boolean isCompleted() {
        return remainingTime == 0;
    }

    // Update the priority of the task based on the remaining burst time
    public void updatePriority() {
        if (remainingTime > 0) {
            priority--;
        }
    }
}
