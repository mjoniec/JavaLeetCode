package easyString;

public class _0389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        var tabS = new int[128];
        var tabT = new int[128];
        for(int i = 0; i<s.length(); i++) tabS[s.charAt(i)]++;
        for(int i = 0; i<t.length(); i++) tabT[t.charAt(i)]++;

        for(int i = 0; i<128; i++) if(tabS[i] != tabT[i]) return (char) i;

        return 'a';
    }

    public void run() {
        System.out.println("_0389_FindTheDifference: ");
        System.out.println("Expected: c Actual: " + findTheDifference("aaabbb", "ababcab"));
    }
}
