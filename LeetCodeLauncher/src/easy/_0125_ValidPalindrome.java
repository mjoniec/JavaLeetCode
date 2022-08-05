package easy;

public class _0125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<s.length()){
            if(!Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i))){
                i++;
            }
            else if(!Character.isDigit(s.charAt(j)) && !Character.isAlphabetic(s.charAt(j))){
                j--;
            }
            else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            else{
                i++;
                j--;
            }
        }

        return true;
    }

    public void run() {
        System.out.println("_0125_ValidPalindrome: ");
        System.out.println("A man, a plan, a canal: Panama  Expected: true Actual:" + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("0P  Expected: false Actual:" + isPalindrome("0P"));
    }
}
