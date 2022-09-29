package mediumArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040_CombinationSumII {
    private int[] _candidates;
    private List<List<Integer>> _lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        _candidates = candidates;
        _lists = new ArrayList<>();
        recursiveCombinationBuilderWithUniqueCheck(new ArrayList<>(), target, 0);
        return _lists;
    }

    private void recursiveCombinationBuilderWithUniqueCheck(List<Integer> combination, int target, int index){
        for(int i = index; i<_candidates.length; i++){
            while(i>index && _candidates[i] == _candidates[i-1] && i<_candidates.length-1) i++; //forward duplicate
            if(_candidates[i] > target) break;//no combination + end this loop
            var list = new ArrayList<>(combination);
            list.add(_candidates[i]);
            if(_candidates[i] == target){ //new combination + end this loop
                _lists.add(list);
                break;//are we sure? what if negative numbers come to play?
            }
            else { //no combination + continue loop + start new recursive loop
                recursiveCombinationBuilderWithUniqueCheck(list, target - _candidates[i], i+1);
            }
        }
    }

    public void run() {
        System.out.println("_0040_CombinationSumII");
        System.out.println("Expected: [1,1] Actual: " + combinationSum2(new int[]{1,1}, 2));
        System.out.println("Expected: [1,2,2][5] Actual: " + combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println("Expected: [1,1,6][1,2,5][1,7][2,6] Actual: " + combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
