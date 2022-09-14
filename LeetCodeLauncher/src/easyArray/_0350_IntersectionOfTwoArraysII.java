package easyArray;

import java.util.*;

public class _0350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        var map1 = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            if(map1.containsKey(num)){
                map1.put(num, map1.get(num) + 1);
            }
            else{
                map1.put(num, 1);
            }
        }

        var map2 = new HashMap<Integer, Integer>();
        for (int num : nums2) {
            if(map2.containsKey(num)){
                map2.put(num, map2.get(num) + 1);
            }
            else if(map1.containsKey(num)){
                map2.put(num, 1);
            }
        }

        var list = new ArrayList<Integer>();
        map2.forEach((key,value) ->{
            var n = Integer.min(value, map1.get(key));//lower count of occurences of number between 2 arrays
            addNumberNTimes(list, key, n);
        });

        return list.stream().mapToInt(i->i).toArray();
    }

    private void addNumberNTimes(List<Integer> list, int num, int n){
        for(int i = 0; i<n; i++){
            list.add(num);
        }
    }

    public void run() {
        System.out.println("_0350_IntersectionOfTwoArraysII: ");

        var nums1 = new int[]{1,2,2,1};
        var nums2 = new int[]{2,2};
        System.out.println("Expected: 2,2   Actual: " + Arrays.toString(intersect(nums1, nums2)));

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        System.out.println("Expected: 9,4   Actual: " + Arrays.toString(intersect(nums1, nums2)));
    }
}
