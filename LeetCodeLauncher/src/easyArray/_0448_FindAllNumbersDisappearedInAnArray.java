package easyArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0448_FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        var set = new HashSet<Integer>();
        var list = new ArrayList<Integer>();

        for (int num : nums) {
            set.add(num);
        }

        for(int i = 1; i<=nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }

    public void run() {
        System.out.println("_0448_FindAllNumbersDisappearedInAnArray: ");
        System.out.println("Expected: 5,6   Actual: " + findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println("Expected: [2]   Actual: " + findDisappearedNumbers(new int[]{1,1}));
    }
}
