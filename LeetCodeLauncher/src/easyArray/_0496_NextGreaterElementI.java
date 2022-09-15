package easyArray;

import java.util.Arrays;
import java.util.HashMap;

public class _0496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var tab = new int[nums1.length];
        var map = new HashMap<Integer, Integer>();

        for(int i = 0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }

        for(int i = 0; i<nums1.length; i++) {
            int num = nums1[i];
            tab[i] = -1;

            for(int j=map.get(num); j<nums2.length; j++){
                if(nums2[j]>num){
                    tab[i] = nums2[j];
                    break;
                }
            }
        }

        return tab;
    }

    public void run() {
        System.out.println("_0496_NextGreaterElementI: ");
        System.out.println("Expected: [-1,3,-1] Actual: "
                + Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println("Expected: [3,-1] Actual: "
                + Arrays.toString(nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }
}
