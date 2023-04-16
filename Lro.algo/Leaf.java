// package lro.algo;

public class Leaf{
    public static void main(String[] args) {
        //declare threshold array
        long[] threshold = {3573984,8347983,834983,379837,747382};
        //declare real-time data array - ever changing value
        long[] data = {8473,8328,83792,3790,7427392};

        //if any of data[i]<threshold[i] (Scarcity)
        noVenation foo = new noVenation(data,threshold);
        
        //calling the noVenation-scarcity resource Optimization

        //if balanced
        // parallelVenation();
        //calling the parallel resource Optimization

        //
    }
}