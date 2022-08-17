package easyString;

import java.util.HashMap;

public class _0013_RomanToInteger {
    public int romanToInt(String s) {
        String[] keys = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] vals = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        var map = new HashMap<String, Integer>();
        int out = 0;

        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], vals[i]);
        }

        for (int i = 0; i<s.length(); ){
            int charNumber;

            if(i < s.length()-1 && map.containsKey(s.substring(i, i+2))){
                charNumber = 2;
            }
            else {
                charNumber = 1;
            }

            out += map.get(s.substring(i, i+charNumber));
            i+=charNumber;
        }

        return out;
    }

    public void run() {
        System.out.println("_0013_RomanToInteger: ");
        System.out.println("Input: VI Expected: 6 Actual:" + romanToInt("VI"));
        System.out.println("Input: IV Expected: 4 Actual:" + romanToInt("IV"));
        System.out.println("Input: LVIII Expected: 58 Actual:" + romanToInt("LVIII"));
        System.out.println("Input: MCMXCIV Expected: 1994 Actual:" + romanToInt("MCMXCIV"));
    }
}
