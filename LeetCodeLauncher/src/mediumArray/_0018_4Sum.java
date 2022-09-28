package mediumArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> _lists = new ArrayList<>();
        Arrays.sort(nums);

        for (var a = 0; a< n; a++)
        for (var b = a+1; b< n; b++)
        for (var c = b+1; c< n; c++)
        for (var d = c+1; d< n; d++) {
            if(nums[a] + nums[b] + nums[c] + nums[d] < target) continue;
            if(nums[a] + nums[b] + nums[c] + nums[d] == target) {
                var l = new ArrayList<Integer>();
                l.add(nums[a]);
                l.add(nums[b]);
                l.add(nums[c]);
                l.add(nums[d]);
                if(!_lists.stream().anyMatch(e -> e.equals(l))){
                    _lists.add(l);
                }
            }
            else break;
        }

        return  _lists;
    }

    public void run() {
        System.out.println("_0018_4Sum");
        System.out.println("Expected: [-2,-1,1,2],[-2,0,0,2],[-1,0,0,1] Actual: " + fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println("Expected: [-5,-4,-3,1] Actual: " + fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
        System.out.println("Expected: [2,2,2,2] Actual: " + fourSum(new int[]{2,2,2,2,2}, 8));
    }
}
