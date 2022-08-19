package easyArray;

import java.util.Arrays;

public class _0035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = right / 2;

        while(left<= right){
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

            mid = (left+right) / 2;
        }

        return left;
    }

    public void run() {
        System.out.println("_0035_SearchInsertPosition: ");
        System.out.println("Input: [1,3,5,6], t=5   Expected: 2   Actual: "+ searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println("Input: [1,3,5,6], t=2   Expected: 1   Actual: "+ searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println("Input: [1,3,5,6], t=7   Expected: 4   Actual: "+ searchInsert(new int[]{1,3,5,6}, 7));
    }
}
