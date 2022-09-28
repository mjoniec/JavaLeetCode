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

        selectA();

        return  _lists;
    }

    private void selectA(){
        for (var a = 0; a<_numsAsc.length; a++) selectB(a);
    }

    private void selectB(int a){
        for (var b = a+1; b<_numsAsc.length; b++) {
            if(_numsAsc[a] + _numsAsc[b] <= _target) selectC(a, b);
            else break;
        }
    }

    private void selectC(int a, int b){
        for (var c = b+1; c<_numsAsc.length; c++) {
            if(_numsAsc[a] + _numsAsc[b] + _numsAsc[c] <= _target) selectD(a, b, c);
            else break;
        }
    }

    private void selectD(int a, int b, int c){
        for (var d = c+1; d<_numsAsc.length; d++) {
            if(_numsAsc[a] + _numsAsc[b] + _numsAsc[c] + _numsAsc[d] < _target) continue;
            if(_numsAsc[a] + _numsAsc[b] + _numsAsc[c] + _numsAsc[d] == _target) {
                var list = new ArrayList<Integer>();
                list.add(_numsAsc[a]);
                list.add(_numsAsc[b]);
                list.add(_numsAsc[c]);
                list.add(_numsAsc[d]);
                if(!_lists.stream().anyMatch(l -> l.equals(list))){
                    _lists.add(list);
                }
            }
            else break;
        }
    }

    public void run() {
        System.out.println("_0018_4Sum");
        System.out.println("Expected: [-2,-1,1,2],[-2,0,0,2],[-1,0,0,1] Actual: " + fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println("Expected: [2,2,2,2] Actual: " + fourSum(new int[]{2,2,2,2,2}, 8));
    }
}
