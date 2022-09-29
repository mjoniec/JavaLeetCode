package mediumArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047_PermutationsII {
    List<List<Integer>> _lists;
    int[] nums;
    //unique version differs in:
    //nums must be sorted
    //if duplicate detected at a lower index we skip step in the loop
    public List<List<Integer>> permuteUnique(int[] nums) {
        _lists = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        recursivePermutationBuilderWithUniqueCheck(new ArrayList<>(), new boolean[nums.length]);
        return _lists;
    }

    private void recursivePermutationBuilderWithUniqueCheck(List<Integer> permutation, boolean[] flags){
        if(permutation.size() == nums.length) _lists.add(new ArrayList<>(permutation));
        else for(int i=0; i<nums.length; i++){
            if(i > 0 && !flags[i - 1] && nums[i] == nums[i-1]) continue;//backward duplicate
            if(!flags[i]){
                flags[i] = true;
                permutation.add(nums[i]);
                recursivePermutationBuilderWithUniqueCheck(permutation, flags);
                flags[i] = false;//cleanup this step before next step
                permutation.remove(permutation.size()-1);
            }
        }
    }

    public void run() {
        System.out.println("_0047_PermutationsII");
        System.out.println("Expected: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] Actual: " + permuteUnique(new int[]{1,2,3}));
        System.out.println("Expected: [1,1,2][1,2,1][2,1,1] Actual: " + permuteUnique(new int[]{1,1,2}));
    }
}
