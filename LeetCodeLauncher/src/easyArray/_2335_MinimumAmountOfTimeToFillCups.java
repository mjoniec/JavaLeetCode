package easyArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _2335_MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        var sum = 0;
        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int num : amount) queue.add(num);

        while (true) {
            if(queue.peek() == 0){//no cups left
                return sum;
            }
            else {
                var max1 = queue.remove();
                if(queue.peek() != 0){//2 or more cup types left
                    var max2 = queue.remove();
                    max2--;
                    queue.add(max2);
                }

                max1--;
                queue.add(max1);
                sum++;
            }
        }
    }

    public void run() {
        System.out.println("_2335_MinimumAmountOfTimeToFillCups: ");
        System.out.println("Expected: 4  Actual: " + fillCups(new int[]{1,4,2}));
        System.out.println("Expected: 7  Actual: " + fillCups(new int[]{5,4,4}));
        System.out.println("Expected: 5  Actual: " + fillCups(new int[]{5,0,0}));
    }
}
