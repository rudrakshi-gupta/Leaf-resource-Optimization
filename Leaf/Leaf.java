// package lro.algo;
import java.util.*;


public class Leaf{
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String arr[] = { 
        "Memory",
        "Processing_Power" ,
        "Storage",
        "Network","Management"
        };
        int[] priority = new int[5];
        
        int x = 0;
        boolean scarcity = false;
        boolean parallel = false;

        System.out.println("Specify the needs of the below computing resourcres accordnidngly\n"+"Scarcity = 0\n"+"Abundance = 1\n"+"Thresold = 2\n");
        for(int i=0;i< arr.length; i++)
        {
            System.out.print(arr[i]+" : ");
            priority[i] = sc.nextInt();
            if (priority[i]==0) {
                scarcity = true;
            }
            if(priority[i]==1 && x==5){
                parallel = true;
                x++;
            }
        }
        if(scarcity){
            long[] a = {1,2,3,4,5};
            long[] b = {1,2,3,4,5};
            noVenation foo = new noVenation(a,b);
        }
        
        // Parallelvenation manager = new Parallelvenation();
        if(parallel){
            Parallelvenation manager = new Parallelvenation();
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                int p = rand.nextInt(10);
                String description = "Task " + i;
                Task task = new Task(p , description);
                manager.addTask(task);
            }

            manager.executeTasks();
        }
        
        // int count = 0;
        // int max = priority[0];
        // for(int i = 1; i < priority.length; i++) {
        //     if (priority[i] > max) {
        //         max = priority[i];
        //     }
        // }
        // for(int i = 0; i < priority.length; i++) {
        // if(priority[i]!=max){
        //         count++;
        //     }
        // }
        if(count==4)
        {
            pinnate n = new pinnate();
        }
        // else{
        //     palmate;
        // }
    }
}
