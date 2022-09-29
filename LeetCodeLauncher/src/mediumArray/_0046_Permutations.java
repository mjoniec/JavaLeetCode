package mediumArray;

import java.util.ArrayList;
import java.util.List;

public class _0046_Permutations {
    //we know elements are unique so we need to flag visited indexes during looping
    List<List<Integer>> _lists;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        _lists = new ArrayList<>();
        this.nums = nums;
        recursivePermutationBuilder(new ArrayList<>(), new boolean[nums.length]);
        return _lists;
    }

    private void recursivePermutationBuilder(List<Integer> permutation, boolean[] flags){
        if(permutation.size() == nums.length) _lists.add(new ArrayList<>(permutation));
        else for(int i=0; i<nums.length; i++){
            if(!flags[i]){
                flags[i] = true;
                permutation.add(nums[i]);
                recursivePermutationBuilder(permutation, flags);
                flags[i] = false;//cleanup this step before next step
                permutation.remove(permutation.size()-1);
            }
        }
    }

    public void run() {
        System.out.println("_0046_Permutations");
        System.out.println("Expected: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] Actual: " + permute(new int[]{1,2,3}));
    }
}
