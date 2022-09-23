package easyString;

public class _0459_RepeatedSubstringPattern {
    //1. whole string must be comprised from the substring
    // so that includes the beginning of string - we may check only from 0 index - skip middle substrings combinations
    // so not n! >> simple n
    //2. sub string length must give 0 when modulo whole string length
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i<=s.length()/2; i++){
            if(s.length() % i == 0){
                int timesRepeated = s.length() / i;
                var sb = new StringBuilder();
                while(timesRepeated-- > 0) sb.append(s.substring(0,i));
                if(s.equals(sb.toString())) return true;
            }
        }
        return false;
    }

    public void run() {
        System.out.println("_0459_RepeatedSubstringPattern: ");
        System.out.println("Expected: true (ab substring) Actual:" + repeatedSubstringPattern("abab"));
        System.out.println("Expected: false  Actual:" + repeatedSubstringPattern("ababa"));
    }
}
