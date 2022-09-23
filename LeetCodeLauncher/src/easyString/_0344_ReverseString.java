package easyString;

import java.util.Arrays;

public class _0344_ReverseString {
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length-1; i<s.length/2; i++,j--) {
            var c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }

    public void run() {
        System.out.println("_0344_ReverseString: ");

        var tab = "abc".toCharArray();
        reverseString(tab);
        System.out.println("Expected: cba Actual:" + Arrays.toString(tab));

        tab = "abcd".toCharArray();
        reverseString(tab);
        System.out.println("Expected: dcba Actual:" + Arrays.toString(tab));
    }
}
