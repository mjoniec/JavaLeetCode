package mediumArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i<nums.length - 2; i++){
            //repetition slide - number covered in previous loop
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            //sliding pincer window
            int j = i+1;
            int k = nums.length-1;

            //mirror value to sum
            int mirror = -nums[i];

            while(j<k){
                if(nums[j]+nums[k]==mirror){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    //repetition slide
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                else if(nums[j]+nums[k]>mirror){
                    k--;
                }
                else{
                    j++;
                }
            }
        }

        return list;
    }

    public void run() {
        System.out.println("_0015_3Sum: ");
        System.out.println("Given: [-1,0,1,2,-1,-4] Expected: [[-1,-1,2],[-1,0,1]] Actual: "
//                + Arrays.deepToString(threeSum(new int[]{-1,0,1,2,-1,-4}).toArray()));
                + threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
