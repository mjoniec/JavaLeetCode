package easyArray;

import java.util.Arrays;

public class _0027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        var left = 0;
        var right = nums.length - 1;

        while(left <= right){
            if(nums[left] == val){//replace element with one from the end
                nums[left] = nums[right];
                nums[right--] = -1;
            }
            else {//leave element
                left++;
            }
        }

        //System.out.println("tab: " + Arrays.toString(nums));

        return left;
    }

    public void run() {
        System.out.println("_0027_RemoveElement: ");

        System.out.println("Input: [1], 1  Expected: 0, [_]   Actual: " + removeElement(new int[]{1}, 1));
        System.out.println("Input: [2], 3  Expected: 1, [2]   Actual: " + removeElement(new int[]{2}, 3));

        System.out.println("Input: [3,2,2,3], 3  Expected: 2, [2,2,_,_]   Actual: "
                + removeElement(new int[]{3,2,2,3}, 3));

        var tab = new int[]{0,1,2,2,3,0,4,2};

        System.out.println("Input: " + Arrays.toString(tab) + ", 2  Expected: 5, [0,1,4,0,3,_,_,_] " +
                "  Actual: " + removeElement(tab, 2));
    }
}
