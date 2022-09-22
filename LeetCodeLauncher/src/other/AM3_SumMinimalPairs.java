package other;

import java.util.*;

public class AM3_SumMinimalPairs {
    //solution after 1month of leetcode training done in 5 minutes
    //talk
    //the larger the initial part size - the less times we d want to touch it
    //the smaller the more times is occeptable
    //sort table
    //merge 2 smallest into one
    //repeat untill tab size == 1
    public int minimumTime(int numOfParts, int[] parts){
        int work = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        for(var part : parts) queue.add(part);
        while(queue.size()>1) {
            queue.add(queue.remove()+queue.remove());
            work += queue.peek();
        }
        return work;
    }

//    public int sumMinimalPair(int[] tab){
//
//    }

    public void run() {
        System.out.println("OptimalPairs: ");
        System.out.println("Expected:58  Actual: " + minimumTime(4, new int[]{8, 4, 6, 12}));
        System.out.println(minimumTime(4, new int[]{20, 4, 8, 2}));//6+6+8+6+8+20
        System.out.println(minimumTime(4, new int[]{1, 2, 5, 10, 35, 89}));
    }

    //old solution before leetcode training
    public int sumMinimalPair(int[] tab){
        var sum = 0;
        var vec = new Vector<Integer>();
        Collections.addAll(vec, Arrays.stream(tab).boxed().toArray( Integer[]::new));

        while (vec.size() > 1) {
            Collections.sort(vec);
            var min1 = vec.get(0);
            vec.remove(0);
            var min2 = vec.get(0);
            vec.remove(0);
            var newElement = min1 + min2;
            sum +=  newElement;
            vec.add(newElement);
        }

        return sum;
    }
}
