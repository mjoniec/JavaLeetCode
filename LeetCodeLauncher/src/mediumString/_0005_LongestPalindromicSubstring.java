package mediumString;

public class _0005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        for(int i = 0; i<s.length(); i++){
            var lenOdd = countSubPalindromeSize(s, i, i);
            var lenEven = countSubPalindromeSize(s, i, i+1);

            if(lenOdd[0] > lenEven[0]){
                if(lenOdd[0] > max){
                    max = lenOdd[0];
                    left = lenOdd[1];
                    right = lenOdd[2];
                }
            }
            else{
                if(lenEven[0] > max){
                    max = lenEven[0];
                    left = lenEven[1];
                    right = lenEven[2];
                }
            }
        }

        return s.substring(left, right + 1);
    }

    private int[] countSubPalindromeSize(String s, int left, int right) {
        while(left >= 0 && right<s.length() && //substring within s
                s.charAt(left) == s.charAt(right)){ //new outer letters still palindrome
            left--;
            right++;
        }

        //we need to retract last loop
        left++;
        right--;

        //single letter gives 0 - we need to add 1
        return new int[]{right - left + 1, left, right};
    }

    public void run() {
        System.out.println("_0005_LongestPalindromicSubstring: ");
        System.out.println("babad Expected: bab or aba Actual: " + longestPalindrome("babad"));
        System.out.println("cbbd Expected: bb Actual: " + longestPalindrome("cbbd"));
        System.out.println("a Expected: a Actual: " + longestPalindrome("a"));
        System.out.println("ac Expected: a or c Actual: " + longestPalindrome("ac"));
    }
}
