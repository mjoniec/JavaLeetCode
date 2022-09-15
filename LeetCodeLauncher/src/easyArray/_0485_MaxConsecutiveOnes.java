package easyArray;

public class _0485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tmpMax = 0;
        for (int num : nums) {
            if(num == 0){
                tmpMax = 0;
            }
            else {
                tmpMax++;

                if(tmpMax > max){
                    max = tmpMax;
                }
            }
        }

        return max;
    }

    public void run() {
        System.out.println("_0485_MaxConsecutiveOnes: ");
        System.out.println("Expected: 3 Actual: " + findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println("Expected: 2 Actual: " + findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
