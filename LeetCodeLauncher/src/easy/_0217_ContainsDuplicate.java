package easy;

import java.util.HashSet;

public class _0217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        boolean out = false;
        var set = new HashSet<Integer>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }

            set.add(num);
        }

        return out;
    }

    public void run() {
        System.out.println("_0217_ContainsDuplicate: ");
        System.out.println("Expected: true Actual: " + containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println("Expected: false Actual: " + containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println("Expected: true Actual: " + containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
