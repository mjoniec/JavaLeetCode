package mediumArray;

public class _0053_MaximumSubarray {
    //this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
    //Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int max = nums[0], loopMax = nums[0];
        for(int i = 1; i <nums.length; i++){
            loopMax = loopMax < 0 ? nums[i] : loopMax + nums[i];
            if(loopMax > max) max = loopMax;
        }
        return max;
    }

    public void run() {
        System.out.println("_0053_MaximumSubarray: ");
        System.out.println("Input: [-2,1,-3,4,-1,2,1,-5,4] Expected: 6   Actual: " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("Input: [5,4,-1,7,8] Expected: 23   Actual: " + maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
