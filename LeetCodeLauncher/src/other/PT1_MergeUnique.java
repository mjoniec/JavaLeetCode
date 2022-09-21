package other;

import java.util.*;

public class PT1_MergeUnique {
    public int[] mergeUnique(int[] array1, int[] array2){
        Set<Integer> set = new HashSet<>();
        for (var num : array1) set.add(num);
        for (var num : array2) set.add(num);

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
