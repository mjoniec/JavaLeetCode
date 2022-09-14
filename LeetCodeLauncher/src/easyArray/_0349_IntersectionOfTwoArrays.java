package easyArray;

import java.util.Arrays;
import java.util.HashSet;

public class _0349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }

        var set = new HashSet<Integer>();
        for (int num : nums2) {
            if(set1.contains(num)){
                set.add(num);
            }
        }

        return set.stream().mapToInt(i->i).toArray();
    }

    public void run() {
        System.out.println("_0349_IntersectionOfTwoArrays: ");

        var nums1 = new int[]{1,2,2,1};
        var nums2 = new int[]{2,2};
        System.out.println("Expected: 2   Actual: " + Arrays.toString(intersection(nums1, nums2)));

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        System.out.println("Expected: 9,4   Actual: " + Arrays.toString(intersection(nums1, nums2)));
    }
}
