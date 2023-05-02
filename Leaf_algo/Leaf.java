import java.util.*;

public class Leaf {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String arr[] = {
                "Memory",
                "Processing_Power" ,
                "Storage",
                "Network","Management"
        };
        System.out.println("abh");
        int[] priority = new int[5];

        int x = 0;
        boolean scarcity = false;
        boolean parallel = false;

        System.out.println("Specify the needs of the below computing resourcres accordnidngly\n"+"Scarcity = 0\n"+"Abundance = 1\n"+"Threshold = 2\n");
        for(int i=0;i< arr.length; i++)
        {
            System.out.print(arr[i]+" : ");
            priority[i] = sc.nextInt();
            if (priority[i]==0) {
                scarcity = true;
            }
            if(priority[i]==1){
                x++;
                if(x==5) {
                    parallel = true;
                }
            }
        }
        if(scarcity){
            long[] a = {1,2,3,4,5};
            long[] b = {1,2,3,4,5};
            noVenation foo = new noVenation(a,b);
             System.exit(0);
        }
        // // System.out.println(x);

        // System.out.println(parallel);
else if(parallel){
            Parallelvenation manager = new Parallelvenation();
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                int p = rand.nextInt(10);
                String description = "Task " + i;
                Task task = new Task(p , description);
                manager.addTask(task);
            }

            manager.executeTasks();
            System.exit(0);
        }
else {
         int max = priority[0];
         for(int i = 1; i < priority.length; i++) {
             if (priority[i] > max) {
                 max = priority[i];
             }
         }
         for(int i = 0; i < priority.length; i++) {
            if(priority[i]!=max){
                 count++;
            }
         }
        }
     if(count==4)
        {
            pinnate n = new pinnate();
        }
    
      else {
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
