package mediumArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018_4Sum {
    //sort ascending
    //add min+1 to all - all elements are larger than 0 (int overflow)
    //
    public List<List<Integer>> fourSum(int[] numsI, int targetI) {
        int n = numsI.length;
        List<List<Integer>> _lists = new ArrayList<>();
        Arrays.sort(numsI);
        long minFactor = Math.abs(numsI[0])+1;
        long[] nums = new long[n];
        for(var i = 0; i<n; i++) nums[i] = numsI[i] + minFactor;
        long target = targetI + 4 * minFactor;

        for (var a = 0; a< n; a++) {
            if (nums[a] > target) break;
            for (var b = a+1; b< n; b++) {
                if (nums[a] + nums[b] > target) break;
                for (var c = b+1; c< n; c++) {
                    if (nums[a] + nums[b] + nums[c] > target) break;
                    for (var d = c + 1; d < n; d++) {
                        long sum = nums[a] + nums[b] + nums[c] + nums[d];
                        if (sum > target) break;
                        if (sum < target) continue;
                        if (sum == target) {
                            var l = new ArrayList<Integer>();
                            l.add((int) (nums[a] - minFactor));
                            l.add((int) (nums[b] - minFactor));
                            l.add((int) (nums[c] - minFactor));
                            l.add((int) (nums[d] - minFactor));
                            if (!_lists.stream().anyMatch(e -> e.equals(l))) {
                                _lists.add(l);
                            }
                        }
                    }
                }
            }
        }
        return  _lists;
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
