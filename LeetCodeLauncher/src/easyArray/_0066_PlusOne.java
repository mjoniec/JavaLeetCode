package easyArray;

import java.util.Arrays;

public class _0066_PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;

        while (i>=0){
            if(digits[i]==9){
                digits[i--] = 0;
            }
            else {
                digits[i]++;
                break;//we want to stop decrementing i
            }
        }

        //if i decremented beyond the beginning
        // we need to expand the whole table
        if(i >= 0) return digits;

        int[] tab = new int[digits.length+1];//filled with 0 by default

        tab[0] = 1;

        return tab;
    }

    public void run() {
        System.out.println("_0066_PlusOne: ");

        var tab = new int[]{9,9};

        System.out.println("Input: " + Arrays.toString(tab) + " Expected: [1,0,0] " + "  Actual: "
                + Arrays.toString(plusOne(tab)));
        System.out.println("Input: [7,9] Expected: [8,0] " + "  Actual: "
                + Arrays.toString(plusOne(new int[]{7,9})));
    }
}
