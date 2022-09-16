package easyBinary;

import java.util.Arrays;

public class _0190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0, i = 0;
        while(i++ < 32) {
            reversed <<= 1;
            reversed |= n & 0b1;
            n >>= 1;
            //System.out.println("reversed: " + reversed);
            //System.out.println("n: " + n);
        }
        return reversed;
    }
    public void run() {
        System.out.println("_0190_ReverseBits");
        System.out.println("To Reverse: 00000010100101000001111010011100");
        System.out.println("Expected  : 00111001011110000010100101000000");
        System.out.println("Actual    : " + Integer.toBinaryString(reverseBits(0b00000010100101000001111010011100)));
    }
}
