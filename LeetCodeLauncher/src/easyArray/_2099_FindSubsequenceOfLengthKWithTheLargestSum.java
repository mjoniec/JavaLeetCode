package easyArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _2099_FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        var list = new ArrayList<Integer>();

        for(int num : nums) {
            list.add(num);
            if(list.size() > k) list.remove(Collections.min(list));
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public void run() {
        System.out.println("_2099_FindSubsequenceOfLengthKWithTheLargestSum: ");
        System.out.println("Expected: [3,3]  Actual: " + Arrays.toString(maxSubsequence(new int[]{2,1,3,3}, 2)));
        System.out.println("Expected: [-1,3,4]  Actual: " + Arrays.toString(maxSubsequence(new int[]{-1,-2,3,4}, 3)));
        System.out.println("Expected: [3,4]  Actual: " + Arrays.toString(maxSubsequence(new int[]{3,4,3,3}, 2)));
    }
}
