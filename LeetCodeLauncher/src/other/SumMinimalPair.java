package other;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class SumMinimalPair {
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

    public void run() {
        System.out.println("OptimalPairs: ");
        System.out.println(sumMinimalPair(new int[]{8, 4, 6, 12}));
        System.out.println(sumMinimalPair(new int[]{20, 4, 8, 2}));
        System.out.println(sumMinimalPair(new int[]{1, 2, 5, 10, 35, 89}));
    }
}
