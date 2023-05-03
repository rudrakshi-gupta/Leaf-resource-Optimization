class nonPreemptive implements Comparable<nonPreemptive> {
    private String name1;
    private int priority1;

    public nonPreemptive(String name1, int priority1) {
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
    public int compareTo(nonPreemptive otherTask) {
        if (this.priority1 > otherTask.getPriority()) {
            return -1; // Higher priority
        } else if (this.priority1 < otherTask.getPriority()) {
            return 1; // Lower priority
        } else {
            return 0; // Same priority
        }
    }
}
