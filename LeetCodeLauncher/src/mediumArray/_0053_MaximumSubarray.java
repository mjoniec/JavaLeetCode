package mediumArray;

public class _0053_MaximumSubarray {
    //this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int lastMax = nums[0];

        for(int i = 0; i <nums.length; i++){
            if(lastMax < 0){
                lastMax = nums[i];
            }

            lastMax += nums[i];

            if(lastMax > max){
                max = lastMax;
            }
        }

        return max;
    }

    public void run() {
        System.out.println("_0053_MaximumSubarray: ");
        System.out.println("Input: [-2,1,-3,4,-1,2,1,-5,4] Expected: 6 Actual: "
                + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}
