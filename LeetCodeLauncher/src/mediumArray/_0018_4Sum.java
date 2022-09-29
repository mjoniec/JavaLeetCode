package mediumArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018_4Sum {
    //1. sort ascending
    //2. reduce complexity of the problem by using sum3 solution in a loop as a 4sum
    //3. unique values in answer lists - how?
    //   forward index if duplicate value already covered (faster than collection.any search)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> _lists = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (var a = 0; a<n-3; a++) {
            if(a!=0) a = forwardIndexIfDuplicate(a, n-3, nums);
            for (var b = a+1; b<n-2; b++) {
                if(b!=a+1) b = forwardIndexIfDuplicate(b, n-2, nums);
                var c = b+1;
                var d = n-1;
                while(c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        _lists.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                        c = forwardIndexIfDuplicate(c, d, nums);
                        d = backwardIndexIfDuplicate(d, c, nums);
                    }
                    else if (sum < target) c++;
                    else d--;
                }
            }
        }
        return  _lists;
    }

    private int forwardIndexIfDuplicate(int index, int max, int[] nums){
        while(index < max && nums[index] == nums[index-1]) index++;
        return index;
    }

    private int backwardIndexIfDuplicate(int index, int min, int[] nums){
        while(index > min && nums[index] == nums[index+1]) index--;
        return index;
    }

    public List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
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
