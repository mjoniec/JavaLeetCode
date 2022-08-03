package easy;

import java.util.Arrays;

public class _0268_MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int expectedSum = nums.length * (nums.length + 1) / 2;

        return expectedSum - sum;
    }

    public void run() {
        System.out.println("_0268_MissingNumber");
        System.out.println("Expected: 2 Actual: " + missingNumber(new int[]{3,0,1}));
        System.out.println("Expected: 2 Actual: " + missingNumber(new int[]{0,1}));
        System.out.println("Expected: 8 Actual: " + missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
