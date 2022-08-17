package easyString;

import java.util.Arrays;

public class _0387_FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        var firstOccurecnceAsciiTab = new int[128];
        var secondOccurecnceAsciiTab = new int[128];

        Arrays.fill(firstOccurecnceAsciiTab, -1);
        Arrays.fill(secondOccurecnceAsciiTab, -1);

        var sTab = s.toCharArray();
        for(int i=0; i<s.length();i++){
            var c = sTab[i];
            if(firstOccurecnceAsciiTab[c] == -1){
                firstOccurecnceAsciiTab[c] = i;
            }
            else{
                secondOccurecnceAsciiTab[c] = i;
            }
        }

        //search for non negative min in firstOccurenceTab that also has -1 in secondOccurenceTab
        var min = s.length();

        for(int i=127; i>=0; i--){
            if(firstOccurecnceAsciiTab[i]!=-1 &&
                    secondOccurecnceAsciiTab[i]==-1 &&
                    firstOccurecnceAsciiTab[i] < min){
                min = firstOccurecnceAsciiTab[i];
            }
        }

        if(min == s.length()){
            min = -1;
        }

        return min;
    }

    public void run() {
        System.out.println("_0387_FirstUniqueCharacterInString: ");
        System.out.println("Input: a Expected: 0 Actual:" + firstUniqChar("a"));
        System.out.println("Input: aa Expected: -1 Actual:" + firstUniqChar("aa"));
        System.out.println("Input: aabb Expected: -1 Actual:" + firstUniqChar("aabb"));
        System.out.println("Input: leetcode Expected: 0 Actual:" + firstUniqChar("leetcode"));
        System.out.println("Input: loveleetcode Expected: 2 Actual:" + firstUniqChar("loveleetcode"));
    }
}
