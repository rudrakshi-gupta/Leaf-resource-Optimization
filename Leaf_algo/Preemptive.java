class Preemptive {
    private String name;
    private int priority;
    private int burstTime;
    private int remainingTime;

    public Preemptive(String name, int priority, int burstTime) {
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
