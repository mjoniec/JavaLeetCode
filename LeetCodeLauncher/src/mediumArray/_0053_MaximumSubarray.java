package mediumArray;

public class _0053_MaximumSubarray {
    //this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
    //Kadane's algorithm

    //My comment
    // Are elements pulling their weight? (sum > 0) – we add them.
    // If not we may take a shot with loop max that
    // next element beats all previous
    // if miss shot we dont update global max – no breaking consequence
    public int maxSubArray(int[] nums) {
        int max = nums[0], loop = nums[0];
        for(int i = 1; i <nums.length; i++){
            loop = loop < 0 ? nums[i] : loop + nums[i];
            if(loop > max) max = loop;
        }
        return max;
    }

    public void run() {
        System.out.println("_0053_MaximumSubarray: ");
        System.out.println("Input: [-2,1,-3,4,-1,2,1,-5,4] Expected: 6   Actual: " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("Input: [5,4,-1,7,8] Expected: 23   Actual: " + maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println("Input: [-3,-4,-5] Expected: -3   Actual: " + maxSubArray(new int[]{-3,-4,-5}));
        System.out.println("Input: [7,8,-1, 2] Expected: 16   Actual: " + maxSubArray(new int[]{7, 8,-1, 2}));
        System.out.println("Input: [7,8,-2, 1] Expected: 15   Actual: " + maxSubArray(new int[]{7, 8,-2, 1}));
        System.out.println("Input: [1,-2,9,-2,1] Expected: 9   Actual: " + maxSubArray(new int[]{1,-2,9,-2,1}));
    }
}
