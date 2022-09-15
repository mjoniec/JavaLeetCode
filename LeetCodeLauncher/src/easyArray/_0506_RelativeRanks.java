package easyArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class _0506_RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        var set = new HashSet<Integer>();
        var map = new HashMap<Integer, Integer>();
        var ranks = new String[score.length];

        for(int i = 0; i<score.length; i++){
            set.add(score[i]);
            map.put(score[i], i);
        }

        for(int i = 0; i<score.length; i++){
            var max = Collections.max(set);
            set.remove(max);

            if(i>2){
                ranks[map.get(max)] = "" + (i+1);
            }
            else if(i == 2){
                ranks[map.get(max)] = "Bronze Medal";
            }
            else if(i == 1){
                ranks[map.get(max)] = "Silver Medal";
            }
            else if(i == 0){
                ranks[map.get(max)] = "Gold Medal";
            }
        }

        return ranks;
    }

    public void run() {
        System.out.println("_0506_RelativeRanks: ");
        System.out.println("Expected: \"Gold Medal\",\"Silver Medal\",\"Bronze Medal\",\"4\",\"5\"   Actual: " + Arrays.toString(findRelativeRanks(new int[]{5,4,3,2,1})));
        System.out.println("Expected: \"Gold Medal\",\"5\",\"Bronze Medal\",\"Silver Medal\",\"4\"   Actual: " + Arrays.toString(findRelativeRanks(new int[]{10,3,8,9,4})));
    }
}
