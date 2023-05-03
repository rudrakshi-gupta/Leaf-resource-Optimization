import java.util.*;

public class Leaf {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String arr[] = {
                "Network",
                "Storage",
                "Memory", "Processing_Power"
                , "Management"
        };
        int[] priority = new int[5];

        int x = 0;
        boolean scarcity = false;
        boolean parallel = false;

        System.out.println("Specify the needs of the below computing resourcres accordnidngly\nNOTE : MANAGEMENT CAN NEVER BE 0!!" + "Scarcity = 0\n" + "Thresold = 1\n" + " Abundance= 2\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " : ");
            priority[i] = sc.nextInt();
            while (i == 4 && priority[i] == 0) {
                System.out.print("MANAGEMENT CAN NEVER BE 0!! Enter the management field again : ");
                priority[i] = sc.nextInt();
            }
            if (priority[i] == 0) {
                scarcity = true;
            }
            if (priority[i] == 1) {
                x++;
                if (x == 5) {
                    parallel = true;
                }
            }
        }
        if (scarcity) {
            System.out.println("TRIGGERING NO VENATION RESOURCE OPTIMIZATION");
            System.out.print("Seems like there is a scarcity of resources.\nChoose the type of resource you want\nThresold = 1\nAbundance= 2\nYour choice : ");
            int choose = sc.nextInt();
            noVenation foo = new noVenation(priority, choose);
            System.out.println(Arrays.toString(priority));
            x = 0;
            for (int i = 0; i < priority.length; i++) {
                if(priority[i]==1){
                    x++;
                }
                if (x == 5) {
                    parallel = true;
                }
            }
        }

        if (parallel) {
            System.out.println("TRIGGERING PARALLEL VENATION RESOURCE OPTIMIZATION");
            Parallelvenation manager = new Parallelvenation();
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                int p = rand.nextInt(10);
                String description = "Task " + i;
                Task task = new Task(p, description);
                manager.addTask(task);
            }

            manager.executeTasks();
        } else {
            int max = priority[0];
            for (int i = 1; i < priority.length; i++) {
                if (priority[i] > max) {
                    max = priority[i];
                }
            }
            for (int i = 0; i < priority.length; i++) {
                if (priority[i] != max) {
                    count++;
                }
            }
            if (count == 4) {
                System.out.println("TRIGGERING PINNATE VENATION RESOURCE OPTIMIZATION");
                pinnate n = new pinnate();
            } else {
                System.out.println("TRIGGERING PALMATE VENATION RESOURCE OPTIMIZATION");
                palmateAlgo m = new palmateAlgo();
                // Create a list of tasks with different priorities
                List<nonPreemptive> taskList1 = new ArrayList<>();
                taskList1.add(new nonPreemptive("midrib 1", 3));
                taskList1.add(new nonPreemptive("midrib 2", 1));
                taskList1.add(new nonPreemptive("midrib 3", 2));

                // Sort the tasks by priority
                Collections.sort(taskList1);

                // Process the tasks in order of priority
                for (nonPreemptive task : taskList1) {
                    System.out.println("Processing task: " + task.getName());
                    palmateAlgo.veins();
                    // Perform the task here...

                    System.out.println("Task completed: " + task.getName());
                }
            }
        }
    }
}
