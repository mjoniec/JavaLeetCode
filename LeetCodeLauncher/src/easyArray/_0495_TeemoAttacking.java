package easyArray;

public class _0495_TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int timer = 0;

        for(int t = 0; t < timeSeries.length-1; t++){
            if(timeSeries[t] + duration > timeSeries[t+1]){//partial duration
                timer += timeSeries[t+1] - timeSeries[t];//diff
            }
            else{//full duration
                timer += duration;
            }
        }

        return timer + duration;//last attack always lasts full duration;
    }

    public void run() {
        System.out.println("_0495_TeemoAttacking: ");
        System.out.println("Input: [1,4] 2  Expected: 4   Actual: " + findPoisonedDuration(new int[]{1,4}, 2));
        System.out.println("Input: [1,2] 2  Expected: 3   Actual: " + findPoisonedDuration(new int[]{1,2}, 2));
        System.out.println("Input: [1,2,3,4,5] 5  Expected: 9   Actual: "
                + findPoisonedDuration(new int[]{1,2,3,4,5}, 5));
    }
}
