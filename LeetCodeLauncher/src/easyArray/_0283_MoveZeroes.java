package easyArray;

import java.util.Arrays;

public class _0283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while(right < nums.length-1){
            if(nums[left] != 0) left++;
            nums[left] = nums[++right];
        }

        while (left < nums.length-1){
            nums[++left] = 0;
        }
    }

    public void run() {
        System.out.println("_0283_MoveZeroes: ");

        var nums = new int[]{0,1,0,3};
        moveZeroes(nums);
        System.out.println("Expected: 1,3,0,0 Actual: " + Arrays.toString(nums));

        var nums2 = new int[]{0,1,0,3,12};
        moveZeroes(nums2);
        System.out.println("Expected: 1,3,12,0,0 Actual: " + Arrays.toString(nums2));
    }
}
