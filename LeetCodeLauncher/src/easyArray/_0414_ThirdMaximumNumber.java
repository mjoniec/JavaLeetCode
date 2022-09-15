package easyArray;

import java.util.*;

public class _0414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        var set = new HashSet<Integer>();

        for(int num : nums){
            if(set.contains(num)){
                continue;
            }

            set.add(num);

            if(set.size() > 3){//size shouldn't get pass 4
                set.remove(Collections.min(set));
            }
        }

        if (set.size() == 3){
            return Collections.min(set);
        }

        return Collections.max(set);
    }

    public void run() {
        System.out.println("_0414_ThirdMaximumNumber: ");
        System.out.println("Expected: 1   Actual: " + (thirdMax(new int[]{3,2,1})));
        System.out.println("Expected: 2   Actual: " + (thirdMax(new int[]{1,2})));
        System.out.println("Expected: 1   Actual: " + (thirdMax(new int[]{2,2,3,1})));
    }
}
