package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class MergeUnique {
    public int[] mergeUnique(int[] array1, int[] array2){
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i : array1){
            if(!set.contains(i)){
                set.add(i);
            }
        }

        for (int i : array2){
            if(!set.contains(i)){
                set.add(i);
            }
        }

        var list = new ArrayList<>(set);

        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void run() {

        var t = mergeUnique(
                new int[]{3, 1, 2, 2, 3},
                new int[]{5, 1, 2, 5}
        );

        System.out.println("MergeUnique: " + Arrays.toString(t));
    }
}
