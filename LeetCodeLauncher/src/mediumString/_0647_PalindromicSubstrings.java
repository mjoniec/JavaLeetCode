package mediumString;

public class _0647_PalindromicSubstrings {

    //one loop per each i:
    // -1: we substring from i both left right until not a palindrome or end of string
    // -2 we do the same for +1 (odd number of letters and even

    public int countSubstrings(String s) {
        int[] count = {0};
        for(int i = 0; i<s.length(); i++){
            countPalindromes(s, i, i, count);
            countPalindromes(s, i, i+1, count);
        }
        return count[0];
    }

    private boolean countPalindromes(String s, int left, int right, int[] count) {
        while(left >= 0 && right<s.length() && //substring within s
                s.charAt(left--) == s.charAt(right++)){ //new outer letters still palindrome
            count[0]++;
        }

        return true;
    }

    //n! solution below
//    public int countSubstrings(String s) {
//        int count = 0;
//        for(int left = 0; left<s.length(); left++){
//            for(int right = left; right<s.length(); right++){
//                if(isPalindrome(s.substring(left, right+1))){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private boolean isPalindrome(String s) {
//        int i = 0;
//        int j = s.length()-1;
//        //System.out.println("s: " + s);
//
//        while(i<s.length()){
//            if(!Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i))){
//                i++;
//            }
//            else if(!Character.isDigit(s.charAt(j)) && !Character.isAlphabetic(s.charAt(j))){
//                j--;
//            }
//            else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
//                return false;
//            }
//            else{
//                i++;
//                j--;
//            }
//        }
//
//        return true;
//    }

    public void run() {
        System.out.println("_0647_PalindromicSubstrings: ");
        System.out.println("abc Expected: 3 Actual: " + countSubstrings("abc"));
        System.out.println("aaa Expected: 6 Actual: " + countSubstrings("aaa"));
        System.out.println("a lot aaaaaa... Expected: a lot without infinite wait Actual: " + countSubstrings("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
