package mediumArray;

import java.util.Arrays;

public class _0238_ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        for(int i = 0, mul = 1; i<nums.length; mul*=nums[i], i++){
            answer[i] = mul;
        }
        //System.out.println("tmp: " + Arrays.toString(answer));

        for(int i = nums.length-1, mul = 1; i>=0; mul*=nums[i], i--){
            answer[i] *= mul;
        }
        //System.out.println("tmp: " + Arrays.toString(answer));

        return answer;
    }

    public void run() {
        System.out.println("_0238_ProductArrayExceptSelf: ");
        System.out.println("Given: [1,2,3,4] Expected: [24,12,8,6] Actual: "
            + Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));

        System.out.println("Given: [2,3,4,5] Expected: [60,40,30,24] Actual: "
                + Arrays.toString(productExceptSelf(new int[]{2,3,4,5})));
        //           [a,  b,  c,  d]
        //1 for mul>>[1, a, ab, abc]
        //           [bcd, cd, d, 1]<<2 for mul
        //          [bcd,acd,abd,abc]
    }
}
