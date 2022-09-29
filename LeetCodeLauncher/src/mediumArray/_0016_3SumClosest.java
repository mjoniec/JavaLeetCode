package mediumArray;

import java.util.Arrays;

public class _0016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(var i = 0; i<nums.length-2; i++){
            var j = i+1;
            var k = nums.length-1;
            while(j<k){//sliding pincer window
                var sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return target; //perfect solution found we can break
                if (Math.abs(target - sum) < Math.abs(minDiff)) minDiff = target - sum; //closer solution
                if (sum > target) k--; else j++; //move only one pincer
            }
        }
        return target - minDiff;
    }

    public void run() {
        System.out.println("_0016_3SumClosest: ");
        System.out.println("Given: [-1,2,1,-4] target:1   Expected: 2 Actual: " + threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println("Given: [4,0,5,-5,3,3,0,-4,-5] target:-2   Expected:-2  Actual: " + threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }
}
