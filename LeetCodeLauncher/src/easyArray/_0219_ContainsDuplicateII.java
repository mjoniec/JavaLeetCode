package easyArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _0219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], set -> new HashSet<>())
                    .add(i);
        }

        for(var set : map.values()){
            var tab = set.toArray();

            for(int i = 1; i < tab.length; i++){
                if(Math.abs((int)tab[i-1] - (int)tab[i]) <= k){
                    return true;
                }
            }
        }

        return false;
    }

    public void run() {
        System.out.println("_0219_ContainsDuplicateII: ");
        System.out.println("Expected: true Actual: " +  containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println("Expected: true Actual: " +  containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println("Expected: false Actual: " + containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
