package easyString;

import java.util.Arrays;

public class _0242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        var asciiTab1 = new int[128];
        var asciiTab2 = new int[128];

        int i = 0;

        while (i < s.length()){
            var c = (int)s.charAt(i++);
            asciiTab1[c]++;
        }

        i = 0;

        while (i < t.length()){
            var c = (int)t.charAt(i++);
            asciiTab2[c]++;
        }

        i = 0;

        //System.out.println("asciiTab1: " + Arrays.toString(asciiTab1));
        //System.out.println("asciiTab2: " + Arrays.toString(asciiTab2));

        while (i < 128){
            if(asciiTab1[i] != asciiTab2[i]) {
                return false;
            }
            i++;
        }

        return true;
    }

    public void run() {
        System.out.println("_0242_ValidAnagram: ");
        System.out.println("anagram  nagaram   Expected: true Actual:" + isAnagram("anagram", "nagaram"));
        System.out.println("anagram  rat car   Expected: false Actual:" + isAnagram("rat", "car"));
    }
}
