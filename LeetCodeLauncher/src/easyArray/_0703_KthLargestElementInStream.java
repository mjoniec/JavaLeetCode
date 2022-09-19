package easyArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _0703_KthLargestElementInStream {
    class KthLargest {
        private PriorityQueue<Integer> queue;
        private int k;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>();
            this.k = k;
            for(var num : nums) add(num);
        }

        public int add(int val) {
            queue.add(val);
            if(queue.size() > k) queue.remove();
            return queue.peek();
        }
    }

    public void run() {
        System.out.println("_0703_KthLargestElementInStream: ");

        var out = new ArrayList<Integer>();
        var kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        out.add(kthLargest.add(3));
        out.add(kthLargest.add(5));
        out.add(kthLargest.add(10));
        out.add(kthLargest.add(9));
        out.add(kthLargest.add(4));

        System.out.println("Expected: [4, 5, 5, 8, 8]  Actual: " + Arrays.toString(out.toArray()));
    }
}
