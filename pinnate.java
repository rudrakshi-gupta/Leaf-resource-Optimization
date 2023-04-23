import java.util.*;

public class PriorityScheduling {

    public static void main(String[] args) {
        
        // Create a priority queue
        PriorityQueue<Runnable> queue = new PriorityQueue<Runnable>(10, new Comparator<Runnable>() {
            public int compare(Runnable o1, Runnable o2) {
                if(o1 == o2) return 0;
                if(o1 instanceof CriticalTask) return -1; // CriticalTask gets highest priority
                return 1; // All other tasks get the same priority
            }
        });
        
        // Add tasks to the queue
        queue.add(new CriticalTask());
        queue.add(new NormalTask());
        queue.add(new NormalTask());
        queue.add(new NormalTask());
        queue.add(new NormalTask());
        
        // Run tasks in order of priority
        while(!queue.isEmpty()) {
            queue.poll().run();
        }
    }
    
    // Define a critical task with highest priority
    private static class CriticalTask implements Runnable {
        public void run() {
            System.out.println("Running critical task");
        }
    }
    
    // Define a normal task with lower priority
    private static class NormalTask implements Runnable {
        public void run() {
            System.out.println("Running normal task");
        }
    }
}