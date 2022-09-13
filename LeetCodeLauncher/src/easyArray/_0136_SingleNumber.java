package easyArray;

import java.util.HashSet;

public class _0136_SingleNumber {
    public int singleNumber(int[] nums) {
        var set = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            var num = nums[i];

            if(set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }

        return set.stream().findFirst().get();
    }

    public void run() {
        System.out.println("_0136_SingleNumber: ");
        System.out.println("Input: [4,1,2,1,2] Expected: 4 " + "  Actual: " + singleNumber(new int[]{4,1,2,1,2}));
        System.out.println("Input: [4] Expected: 4 " + "  Actual: " + singleNumber(new int[]{4}));
    }
}
