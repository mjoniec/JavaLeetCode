package mediumString;

public class _0567_PermutationInString {
    //continuous permutation
    //ascii tab s1
    //left right pointers - if contained within ascitab move right
    // else move left and start over
    int[] asciiTab = new int[128];
    public boolean checkInclusion(String s1, String s2) {
        asciiTab = new int[128];
        int left = 0;
        int right = 0;
        for(var c : s1.toCharArray()) asciiTab[c]++;
        while(right < s2.length()){
            if(isSlidingWindowContainedWithinAsciiTab(left, right, s2)){
                if(isSlidingWindowEqualToAsciiTab(left, right, s2)) return true;
                right++;
            }
            else {
                left++;
                if(left>right) right++;
            }
        }
        return false;
    }

    private boolean isSlidingWindowContainedWithinAsciiTab(int left, int right, String s){
        int[] tab = new int[128];
        for(var i = left; i<=right; i++) tab[s.charAt(i)]++;
        for(int i=0; i<128; i++) if (tab[i]>asciiTab[i]) return false;
        return true;
    }

    private boolean isSlidingWindowEqualToAsciiTab(int left, int right, String s){
        int[] tab = new int[128];
        for(var i = left; i<=right; i++) tab[s.charAt(i)]++;
        for(int i=0; i<128; i++) if (tab[i]!=asciiTab[i]) return false;
        return true;
    }

    public void run() {
        System.out.println("_0567_PermutationInString: ");
        System.out.println("Expected true  Actual: "+checkInclusion("ab", "eidbaooo"));
        System.out.println("Expected false  Actual: "+checkInclusion("ab", "eidboaoo"));
        System.out.println("Expected true  Actual: "+checkInclusion("adc", "dcda"));
        System.out.println("Expected true  Actual: "+checkInclusion("a", "ab"));
    }
}
