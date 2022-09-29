package mediumArray;

import java.util.Arrays;

public class _0016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closestSolution = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i<nums.length - 2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue; //duplicate val forward as covered in previous step
            int j = i+1;//sliding pincer window
            int k = nums.length-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return target;//perfect solution found we can break
                if (Math.abs(sum - target) < Math.abs(closestSolution - target)) closestSolution = sum;
                if(sum > 0) { //move only one pincer
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--; //duplicate val forward
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++; //duplicate val forward
                }
            }
        }

        return closestSolution;
    }

    public void run() {
        System.out.println("_0015_3Sum: ");
        System.out.println("Given: [-1,2,1,-4] target:1   Expected: 2 Actual: " + threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}
