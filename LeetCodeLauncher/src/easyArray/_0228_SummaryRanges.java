package easyArray;

import java.util.ArrayList;
import java.util.List;

public class _0228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        var list = new ArrayList<String>();
        var i = 0;

        while(i < nums.length){
            int left  = nums[i];//always included - only question if alone or with range
            i++;

            while(i < nums.length && nums[i-1] + 1 == nums[i]) {
                i++;
            }

            int right = i < nums.length ? nums[i] : left;

            list.add(left == right
                    ? String.valueOf(left)
                    : (left + "->" + right));
        }

        return list;
    }

    public void run() {
        System.out.println("_0228_SummaryRanges: ");
        System.out.println("Input: [0,1,2,4,5,7]  Expected: [0->2, 4->5, 7]   Actual: "
                + summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
