package easy;

public class _0191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            //System.out.println("mask: " + mask);
            mask <<= 1;
        }

        //simplest one is: Integer.bitCount(n);
        return bits;
    }

    public void run() {
        System.out.println("_0191_NumberOf1Bits: ");
        System.out.println("Expected: 3 Actual: " + hammingWeight(00000000000000000000000000001011));
        System.out.println("Expected: 1 Actual: " + hammingWeight(00000000000000000000000010000000));
        System.out.println("Expected: 31 Actual: " + hammingWeight(-3));
    }
}
