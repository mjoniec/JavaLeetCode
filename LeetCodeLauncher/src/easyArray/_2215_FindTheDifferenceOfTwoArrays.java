package easyArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _2215_FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>>list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();

        for(var num : nums1){
            set1.add(num);
        }
        for(var num : nums2){
            set2.add(num);
        }

        for(var num : set1){
            if(!set2.contains(num)){
                list.get(0).add(num);
            }
        }

        for(var num : set2){
            if(!set1.contains(num)){
                list.get(1).add(num);
            }
        }

        return list;
    }

    public void run() {
        System.out.println("_2215_FindTheDifferenceOfTwoArrays: ");
        System.out.println("Expected: [[1,3],[4,6]]  Actual: " + findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println("Expected: [[3],[]]  Actual: " + findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }
}
