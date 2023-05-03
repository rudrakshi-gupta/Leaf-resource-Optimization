import java.util.*;
public class palmateAlgo {

    public palmateAlgo() {
    }

    public static void veins() {

        List<Preemptive> taskList2 = new ArrayList<>();
        taskList2.add(new Preemptive("vein 1", 3, 5));
        taskList2.add(new Preemptive("vein 2", 1, 2));
        taskList2.add(new Preemptive("vein 3", 2, 4));
        taskList2.add(new Preemptive("vein 4", 4, 3));

        // Create a priority queue to store the tasks in the order they should be processed
        PriorityQueue<Preemptive> taskQueue = new PriorityQueue<>(new Comparator<Preemptive>() {
            @Override
            public int compare(Preemptive task1, Preemptive Preemptive) {
                if (task1.getPriority() > Preemptive.getPriority()) {
                    return -1; // Higher priority
                } else if (task1.getPriority() < Preemptive.getPriority()) {
                    return 1; // Lower priority
                } else {
                    return 0; // Same priority
                }
            }
        });

        // Add the tasks to the queue
        taskQueue.addAll(taskList2);

        // Process the tasks in order of priority and burst time
        int currentTime = 0;
        Preemptive currentTask = null;
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
