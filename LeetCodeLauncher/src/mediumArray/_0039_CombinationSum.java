package mediumArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//it assumes the input nums are unique and sorted
public class _0039_CombinationSum {
    private int[] _candidates;
    private List<List<Integer>> _lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        _lists = new ArrayList<>();
        var list = new ArrayList<Integer>();
        for(var c : candidates) list.add(c);
        Collections.sort(list);
        _candidates = list.stream().mapToInt(Integer::intValue).toArray();
        BruteForceRecursiveSearch(new ArrayList<>(), target);
        return _lists;
    }

    private void BruteForceRecursiveSearch(List<Integer> selectedCandidates, int target){
        int max = 0;
        if(selectedCandidates.size() > 0) max = Collections.max(selectedCandidates);
        for (var c : _candidates){
            if(c<max) continue;//prevents duplicates
            if(c < target){
                var list = new ArrayList<>(selectedCandidates);
                list.add(c);
                BruteForceRecursiveSearch(list, target-c);
            }
            else if (c == target){
                var list = new ArrayList<>(selectedCandidates);
                list.add(c);
                _lists.add(list);
            }
            else {
                break;
            }
        }
    }

    public void run() {
        System.out.println("_0039_CombinationSum");
        System.out.println("Expected: [2,2,3],[7] Actual: " + combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println("Expected: [2,2,2,2],[2,3,3],[3,5] Actual: " + combinationSum(new int[]{2,3,5}, 8));
    }
}
