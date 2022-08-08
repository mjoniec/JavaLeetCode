package mediumString;

import java.util.Arrays;

public class _0424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int right = 0;
        var left = 0;
        var max = 0;//we only need to remember max
        var asciiTab = new int[128];

        while(right<s.length()){
            asciiTab[s.charAt(right)]++;
            var currentWindowMax = Arrays.stream(asciiTab).max().getAsInt();

            if(currentWindowMax + k < right - left + 1){
                asciiTab[s.charAt(left)]--;
                left++;
            }

            if (max < (right - left + 1)){
                max = right - left + 1;
            }

            right++;
        }

        return right - left;
    }

    public void run() {
        System.out.println("_0424_LongestRepeatingCharacterReplacement: ");
        System.out.println("ABAB + 2 >> Expected 4 Actual: "+characterReplacement("ABAB", 2));
        System.out.println("AABABBA + 2 >> Expected 4 Actual: "+characterReplacement("AABABBA", 1));
    }
}
