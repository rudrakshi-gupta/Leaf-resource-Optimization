// import java.util.*;

// public class algo {
//     public static void main(String[] args) {
//         // Create a list of tasks with different priorities
//         List<Task1> taskList = new ArrayList<>();
//         taskList.add(new Task1("midrib 1", 3));
//         taskList.add(new Task1("midrib 2", 1));
//         taskList.add(new Task1("midrib 3", 2));

//         // List<Task2> taskList2 = new ArrayList<>();

//         // Sort the tasks by priority
//         Collections.sort(taskList);

//         // Process the tasks in order of priority
//         for (Task1 task : taskList) {
//             System.out.println("Processing task: " + task.getName());
//             PriorityScheduling();
//             // Perform the task here...
//             System.out.println("Task completed: " + task.getName());
            

//         }
//     }

//     private static void PriorityScheduling() {

//         // Create a priority queue for the tasks
//         PriorityQueue<Task2> taskQueue = new PriorityQueue<>();

//                 // Create tasks with different priorities
//         Task2 highestPriorityTask = new Task2("Highest Priority vein", 1);
//         Task2 otherTask1 = new Task2("vein 1", 2);
//         Task2 otherTask2 = new Task2("vein 2", 2);
        
//                 // Add the tasks to the queue
//         taskQueue.add(highestPriorityTask);
//         taskQueue.add(otherTask1);
//         taskQueue.add(otherTask2);
        
//                 // Process the tasks in priority order
//         while (!taskQueue.isEmpty()) {
//             Task2 currentTask = taskQueue.poll();
//                 System.out.println("Processing task: " + currentTask.getName());
        
//                     // Perform the task here...
        
//                 System.out.println("Task completed: " + currentTask.getName());
//         }
        

//     }
// }

// class Task1 implements Comparable<Task1> {
//     private String name;
//     private int priority;

//     public Task1(String name, int priority) {
//         this.name = name;
//         this.priority = priority;
//     }

//     public String getName() {
//         return name;
//     }

//     public int getPriority() {
//         return priority;
//     }

//     // Compare tasks by priority
//     @Override
//     public int compareTo(Task1 otherTask) {
//         if (this.priority > otherTask.getPriority()) {
//             return -1; // Higher priority
//         } else if (this.priority < otherTask.getPriority()) {
//             return 1; // Lower priority
//         } else {
//             return 0; // Same priority
//         }
//     }


// }

// class PriorityScheduling {
//     public static void main(String[] args) {
//     }
// }

// class Task2 implements Comparable<Task2> {
//     private String name;
//     private int priority;

//     public Task2(String name, int priority) {
//         this.name = name;
//         this.priority = priority;
//     }

//     public String getName() {
//         return name;
//     }

//     public int getPriority() {
//         return priority;
//     }

//     // Compare tasks by priority
//     @Override
//     public int compareTo(Task2 otherTask) {
//         if (this.priority > otherTask.getPriority()) {
//             return -1; // Higher priority
//         } else if (this.priority < otherTask.getPriority()) {
//             return 1; // Lower priority
//         } else {
//             return 0; // Same priority
//         }
//     }
// }





import java.util.*;
public class palmateAlgo {
    public static void main(String[] args) {
        // Create a list of tasks with different priorities
        List<Task> taskList1 = new ArrayList<>();
        taskList1.add(new Task("midrib 1", 3));
        taskList1.add(new Task("midrib 2", 1));
        taskList1.add(new Task("midrib 3", 2));

        // Sort the tasks by priority
        Collections.sort(taskList1);

        // Process the tasks in order of priority
        for (Task task : taskList1) {
            System.out.println("Processing task: " + task.getName());
            veins();
            // Perform the task here...

            System.out.println("Task completed: " + task.getName());
        }
    }

    public static void veins() {

        List<Task2> taskList2 = new ArrayList<>();
        taskList2.add(new Task2("vein 1", 3, 5));
        taskList2.add(new Task2("vein 2", 1, 2));
        taskList2.add(new Task2("vein 3", 2, 4));
        taskList2.add(new Task2("vein 4", 4, 3));

        // Create a priority queue to store the tasks in the order they should be processed
        PriorityQueue<Task2> taskQueue = new PriorityQueue<>(new Comparator<Task2>() {
            @Override
            public int compare(Task2 task1, Task2 task2) {
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
        taskQueue.addAll(taskList2);

        // Process the tasks in order of priority and burst time
        int currentTime = 0;
        Task2 currentTask = null;
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


class Task implements Comparable<Task> {
    private String name1;
    private int priority1;

    public Task(String name1, int priority1) {
        this.name1 = name1;
        this.priority1 = priority1;
    }

    public String getName() {
        return name1;
    }

    public int getPriority() {
        return priority1;
    }

    // Compare tasks by priority
    @Override
    public int compareTo(Task otherTask) {
        if (this.priority1 > otherTask.getPriority()) {
            return -1; // Higher priority
        } else if (this.priority1 < otherTask.getPriority()) {
            return 1; // Lower priority
        } else {
            return 0; // Same priority
        }
    }
}

class Task2 {
    private String name;
    private int priority;
    private int burstTime;
    private int remainingTime;

    public Task2(String name, int priority, int burstTime) {
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