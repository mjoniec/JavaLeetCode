package easyArray;

import java.util.*;

public class _0561_ArrayPartition {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();//duplicates

        for(var num : nums){
            queue.add(num);
        }

        for(int i = 0; i < nums.length/2; i++){
            sum += queue.remove();
            queue.remove();
        }

        return sum;
    }

    public void run() {
        System.out.println("_0561_ArrayPartition: ");
        System.out.println(" Expected: 4   Actual: " + arrayPairSum(new int[]{1,4,3,2}));
        System.out.println(" Expected: 9   Actual: " + arrayPairSum(new int[]{6,2,6,5,1,2}));
    }
}
