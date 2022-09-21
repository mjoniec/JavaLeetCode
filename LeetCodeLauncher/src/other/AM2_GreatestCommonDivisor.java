package other;

public class AM2_GreatestCommonDivisor {
    public int gcd(int[] nums){
        int max = 1;

        for(int i = 0; i<nums.length; i++){
            boolean allDividable = true;
            for(int j = 0; j<nums.length; j++){
                if(nums[j]%nums[i] != 0) allDividable = false;
            }
            if(allDividable && nums[i]>max) max = nums[i];
        }

        return max;
    }

    public void run() {
        System.out.println("AM2_GreatestCommonDivisor: ");
        System.out.println("Expected: 2 Actual:" + gcd(new int[]{4,6,2,8,10}));
    }
}
