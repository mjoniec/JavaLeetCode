package mediumString;

public class _1143_LongestCommonSubsequence {
    String text1;
    String text2;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        return lcs(text1.length(), text2.length());
    }

    private int lcs(int x, int y){
        if(x==0 || y==0) return 0;
        return text1.charAt(x-1) == text2.charAt(y-1)
            ? 1 + lcs(x-1, y-1)
            : Math.max(lcs(x-1, y), lcs(x, y-1));
    }

    public void run() {
        System.out.println("_1143_LongestCommonSubsequence: ");
        System.out.println("Expected 3  Actual: "+longestCommonSubsequence("abcde", "ace"));
        System.out.println("Expected 0  Actual: "+longestCommonSubsequence("abc", "def"));
        System.out.println("Expected 1  Actual: "+longestCommonSubsequence("bl", "yby"));
    }
}
