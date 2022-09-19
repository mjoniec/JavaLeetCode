package easyArray;

import java.util.PriorityQueue;

public class _2335_MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        var queue = new PriorityQueue<Integer>();

        var a = queue.r
    }

    public void run() {
        System.out.println("_2335_MinimumAmountOfTimeToFillCups: ");
        System.out.println("Expected: 4  Actual: " + fillCups(new int[]{1,4,2}));
        System.out.println("Expected: 7  Actual: " + fillCups(new int[]{5,4,4}));
        System.out.println("Expected: 5  Actual: " + fillCups(new int[]{5,0,0}));
    }
}
