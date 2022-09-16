package easyArray;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0455_AssignCookies {
    public int findContentChildren(int[] children, int[] cookies) {
        int sum = 0;
        Queue<Integer> childrenQueue = new PriorityQueue<>();
        Queue<Integer> cookiesQueue = new PriorityQueue<>();

        for(var c : children){
            childrenQueue.add(c);
        }
        for(var c : cookies){
            cookiesQueue.add(c);
        }

        while(childrenQueue.size()>0 && cookiesQueue.size()>0){
            var child = childrenQueue.peek();
            var cookie = cookiesQueue.peek();
            if(child <= cookie){
                sum++;
                childrenQueue.remove();
            }

            cookiesQueue.remove();
        }

        return sum;
    }

    public void run() {
        System.out.println("_0455_AssignCookies: ");
        System.out.println("Expected: 1  Actual: " + findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println("Expected: 2  Actual: " + findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
