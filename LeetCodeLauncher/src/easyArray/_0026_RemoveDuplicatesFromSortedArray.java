package easyArray;

public class _0026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int k = 0;

        for(int i=0; i<nums.length;i++){

            if(nums[i] == -1) return k;
            if(i==nums.length-1) return++k;

            if(nums[i]==nums[i+1] && (i+1!=nums.length-1)){
                for (int j=i+1; j<nums.length-1;j++){
                    nums[j] = nums[j+1];
                }
                nums[nums.length-1] = -1;
                i--;
            }
            else {
                k++;
            }
        }

        return k;
    }

    public void run() {
        System.out.println("_0026_RemoveDuplicatesFromSortedArray: ");
        System.out.println("Input: [1,1]  Expected: 1   Actual: "
                + removeDuplicates(new int[]{1,1}));
        System.out.println("Input: [1,2]  Expected: 2   Actual: "
                + removeDuplicates(new int[]{1,2}));
        System.out.println("Input: [1,1,2]  Expected: 2   Actual: "
                + removeDuplicates(new int[]{1,1,2}));
        System.out.println("Input: [0,0,1,1,1,2,2,3,3,4]  Expected: 5   Actual: "
                + removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
