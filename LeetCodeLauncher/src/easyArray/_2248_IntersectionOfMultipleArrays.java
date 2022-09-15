package easyArray;

import java.util.*;

public class _2248_IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        var list = new ArrayList<Integer>();
        var map = new HashMap<Integer, Integer>();

        for(var tab : nums){
            for(int num : tab){
                if(map.containsKey(num)){
                    map.put(num, map.get(num) + 1);
                }
                else{
                    map.put(num, 1);
                }
            }
        }

        map.forEach((key,value) -> {
            if(value == nums.length){
                list.add(key);
            }
        });

        Collections.sort(list);

        return list;
    }

    public void run() {
        System.out.println("_2248_IntersectionOfMultipleArrays: ");

        var nums = new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println("Expected: [3,4]   Actual: " + intersection(nums));

        nums = new int[][]{{1,2,3},{4,5,6}};
        System.out.println("Expected: []   Actual: " + intersection(nums));
    }
}
