package easyString;

public class _0409_LongestPalindrome {
    //ascii tab all letters
    //count pairs and remove from ascii tab
    //add one last single letter if exist (middle letter mirrors itself)
    public int longestPalindrome(String s) {
        var count = 0;
        var tab = new int[128];
        for(int i = 0; i<s.length(); i++) tab[s.charAt(i)]++;
        for(int i = 0; i<128; i++) {
            while(tab[i] >= 2){
                tab[i] -= 2;
                count += 2;
            }
        }

        for(int i = 0; i<128; i++) {
            if(tab[i] > 0){
                count++;
                break;
            }
        }

        return count;
    }

    public void run() {
        System.out.println("_0409_LongestPalindrome: ");
        System.out.println("Expected: 7  Actual:" + longestPalindrome("abccccdd"));
        System.out.println("Expected: 1  Actual:" + longestPalindrome("a"));
    }
}
