package easy;

import java.util.Arrays;

public class _0070_ClimbingStairs {
    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[]tab = new int[n];
        tab[0]=1;
        tab[1]=2;
        for(int i = 2; i<n; i++){
            tab[i] = tab[i-1]+tab[i-2];
        }
        return tab[n-1];
    }
    //    public int climbStairs(int n) {
//        if(n==0){
//            return 0;
//        }
//        if(n==1){
//            return 1;
//        }
//        if(n==2){
//            return 2;
//        }
//        return climbStairs(n-1)+climbStairs(n-2);
//    }

    public void run() {
        System.out.println("_0070_ClimbingStairs");
        System.out.println("Expected: 2 Actual: " + climbStairs(2));
        System.out.println("Expected: 3 Actual: " + climbStairs(3));
        System.out.println("Expected: 5 Actual: " + climbStairs(4));
    }
}
