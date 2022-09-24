package easyString;

public class _0521_LongestUncommonSubsequenceI {
    //what is a subsequence and longest anti subsequence?
    //zzAzzBzzCzz - ABC
    //zzAzzBzzCzz - zzzzzzzz (8 length)

    //what data structure we need to describe string
    //hashmap - key>>char  value>>set of indexes of letter occurrences

    //comparison utilizing data representation...
    //foreach subsequence char ABC: find first index occurence - move left pointer there
    //if any check happens before left pointer - not a subsequence

    //this does not cover multiple letter occurences
    // we need a flag or -int mark or perhaps removal from index set

    //then I SAW COMMENTS ON 1 liner simple solution
    //"I know right? I over-thought just like you too!"
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public void run() {
        System.out.println("_0520_DetectCapital: ");
        System.out.println("Expected: 3 Actual:" + findLUSlength("aba", "cdc"));
        System.out.println("Expected: -1 Actual:" + findLUSlength("aaa", "aaa"));

        //one liner doesn work - but it passes submission...
        //maybe I misunderstood and overcomplicated
        System.out.println("Expected: 8 Actual:" + findLUSlength("ABC", "zzAzzBzzCzz"));
    }
}
