
import java.util.*;
public class main {
    public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
        String arr[] = {
        "Memory",
        "Processing_Power" ,
        "Storage",
        "Network","Management"
        };
    int[] priority = new int[5];


    System.out.println("Specify the needs of the below computing resourcres accordnidngly\n"+"Scarcity = 0\n"+"Abundance = 1\n"+"Thresold = 2\n");
    
    for(int i=0;i< arr.length; i++)
    {
        System.out.print(arr[i]+" : ");
        priority[i] = sc.nextInt();
    }

    }
}
