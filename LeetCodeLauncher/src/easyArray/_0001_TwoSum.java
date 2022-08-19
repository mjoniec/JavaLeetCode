package easyArray;

import java.util.Arrays;

public class _0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public void run() {
        System.out.println("_0001_TwoSum: ");
        System.out.println("Input: [2,7,11,15], 9   Expected: [0,1]   Actual: "+
                Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
}
