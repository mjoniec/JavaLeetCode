package easyArray;

import java.util.Arrays;

public class _0026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;

        while(right < nums.length) {
            int num = nums[right];

            while (right < nums.length && nums[right] == num) {
                right++;
            }

            nums[left++] = num;
        }

        //System.out.println(Arrays.toString(nums));

        return left;
    }

    public void run() {
        System.out.println("_0026_RemoveDuplicatesFromSortedArray: ");
        System.out.println("Input: [1,1]  Expected: 1   Actual: "
                + removeDuplicates(new int[]{1,1}));
        System.out.println("Input: [1,2]  Expected: 2   Actual: "
                + removeDuplicates(new int[]{1,2}));
        System.out.println("Input: [1,1,2]  Expected: 2   Actual: "
                + removeDuplicates(new int[]{1,1,2}));
        System.out.println("Input: [0,0,1,1,1,2,2,3,3,4]  Expected: 5   Actual: "
                + removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
