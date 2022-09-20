package easyDynamicProgramming;

public class _0509_FibonacciNumber {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-2)+fib(n-1);
    }

    public void run() {
        System.out.println("_0509_FibonacciNumber");
        System.out.println("Expected: 8 Actual: " + fib(6));
    }
}
