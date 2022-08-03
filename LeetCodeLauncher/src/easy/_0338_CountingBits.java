package easy;

import java.util.Arrays;

public class _0338_CountingBits {
    public int[] countBits(int n) {
        int[] tab = new int[n+1];

        for(int i = 0; i<=n; i++){
            tab[i] = Integer.bitCount(i);
        }

        return tab;
    }

    public void run() {
        System.out.println("_0338_CountingBits");
        System.out.println("Expected: [0,1,1] Actual: " + Arrays.toString(countBits(2)));
        System.out.println("Expected: [0,1,1,2,1,2] Actual: " + Arrays.toString(countBits(5)));
    }
}
