package easyDynamicProgramming;

public class _0746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int one = cost[0];
        int two = cost[1];

        for (int i = 2; i<cost.length; i++){
            var min = Math.min(one, two);
            one = two;
            two = min + cost[i];
        }

        return Math.min(one, two);
    }

    public void run() {
        System.out.println("_0746_MinCostClimbingStairs");
        System.out.println("Input:[1,100,1,1,1,100,1,1,100,1]  Expected: 6 Actual: " +
                minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
