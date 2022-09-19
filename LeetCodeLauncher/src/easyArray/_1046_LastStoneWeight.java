package easyArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(var stone : stones){
            queue.add(stone);
        }

        while(queue.size() > 1){
            var x = queue.remove();
            var y = queue.remove();
            var diff = Math.abs(x-y);
            if(diff>0) queue.add(diff);
        }

        return queue.size() == 0 ? 0 : queue.poll();
    }

    public void run() {
        System.out.println("_0703_KthLargestElementInStream: ");
        System.out.println("Expected: 1  Actual: " + lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println("Expected: 1  Actual: " + lastStoneWeight(new int[]{1}));
    }
}
