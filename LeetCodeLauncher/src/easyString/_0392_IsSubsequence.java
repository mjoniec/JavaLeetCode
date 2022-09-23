package easyString;

public class _0392_IsSubsequence {
    //no counting and storing amount of char occurences
    //2 pointers
    //foreach letter in substring
    //we find index of first occurence of that letter in s
    //each search starts from last found index
    //so basically 2 loops or 2 pointers race
    //true - if substring ptr reaches end first - index < t.length
    //false - if we run out of letter to check in t - index == t.length
    public boolean isSubsequence(String s, String t) {
        int subindex = 0;
        int index = 0;
        while(subindex < s.length()){
            while(index < t.length())
                if(s.charAt(subindex) == t.charAt(index++)) {
                    subindex++;
                    break;
                }
            if(index == t.length() && subindex < s.length()) return false;
        }

        return subindex == s.length();
    }

    public void run() {
        System.out.println("_0392_IsSubsequence: ");
        System.out.println("Expected: true  Actual:" + isSubsequence("ace", "abcde"));
        System.out.println("Expected: false  Actual:" + isSubsequence("aec", "abcde"));
        System.out.println("Expected: false  Actual:" + isSubsequence("axc", "ahbgdc"));
    }
}
