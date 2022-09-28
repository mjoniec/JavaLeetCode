package mediumArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0018_4Sum {
    private int _target;
    private int[] _numsAsc;
    private List<List<Integer>> _lists = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        _target = target;
        _lists = new ArrayList<>();
        var list = new ArrayList<Integer>();
        for(var c : nums) list.add(c);
        Collections.sort(list);
        _numsAsc = list.stream().mapToInt(Integer::intValue).toArray();

        for (var a = 0;   a<_numsAsc.length; a++)
        for (var b = a+1; b<_numsAsc.length; b++)
        for (var c = b+1; c<_numsAsc.length; c++)
        for (var d = c+1; d<_numsAsc.length; d++) {
            if(_numsAsc[a] + _numsAsc[b] + _numsAsc[c] + _numsAsc[d] < _target) continue;
            if(_numsAsc[a] + _numsAsc[b] + _numsAsc[c] + _numsAsc[d] == _target) {
                var l = new ArrayList<Integer>();
                l.add(_numsAsc[a]);
                l.add(_numsAsc[b]);
                l.add(_numsAsc[c]);
                l.add(_numsAsc[d]);
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
