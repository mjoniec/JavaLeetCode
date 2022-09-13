package easyArray;

import java.util.HashMap;

public class _0169_MajorityElement {
    public int majorityElement(int[] nums) {
        var maxCount = 0;
        var maxNum = 0;
        var map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            var num = nums[i];

            map.merge(num, 1, Integer::sum);

            if(map.get(num) > maxCount){
                maxCount = map.get(num);
                maxNum = num;
            }
        }

        return maxNum;
    }

    public void run() {
        System.out.println("_0169_MajorityElement: ");
        System.out.println("Input: [3,2,3] Expected: 3 " + "  Actual: " + majorityElement(new int[]{3,2,3}));
        System.out.println("Input: [2,2,1,1,1,2,2] Expected: 2 " + "  Actual: " + majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
