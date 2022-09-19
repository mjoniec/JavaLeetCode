package easyArray;

import java.util.Arrays;

public class _2357_MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        int out = 0;

        while(Arrays.stream(nums).anyMatch(num -> num!=0)){
            var min = Arrays.stream(nums).filter(num-> num>0).min().getAsInt();
            for(int i = 0; i<nums.length; i++) if(nums[i] > 0) nums[i] -= min;
            out++;
        }

        return out;
    }

    public void run() {
        System.out.println("_2357_MakeArrayZeroBySubtractingEqualAmounts: ");
        System.out.println("Expected: 3  Actual: " + minimumOperations(new int[]{1,5,0,3,5}));
        System.out.println("Expected: 0  Actual: " + minimumOperations(new int[]{0}));
    }
}
