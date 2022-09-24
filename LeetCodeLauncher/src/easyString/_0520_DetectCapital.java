package easyString;

public class _0520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.chars().allMatch(c-> c >=65 && c <=90)) return true;
        if(word.chars().allMatch(c-> c >=97 && c <=122)) return true;
        if(word.charAt(0)>=65 && word.charAt(0)<=90
            && word.substring(1).chars().allMatch(c-> c >=97 && c <=122)) return true;
        return false;
    }

    public void run() {
        System.out.println("_0520_DetectCapital: ");
        System.out.println("Expected: true Actual:" + detectCapitalUse("USA"));
        System.out.println("Expected: false  Actual:" + detectCapitalUse("FlaG"));
    }
}
