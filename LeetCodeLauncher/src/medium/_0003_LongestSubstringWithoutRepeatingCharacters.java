package medium;

public class _0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){
        int left = 0;
        int right = 0;
        int max = 0;
        int[] asciiTab = new int[128];

        while (right < s.length()) {
            var c = (int) s.charAt(right);

            if(asciiTab[c] != 0 && left < asciiTab[c]){
                left = asciiTab[c];
            }

            if(max < right - left + 1){
                max = right - left + 1;
            }

            right++;
            asciiTab[c] = right;
        }

        return max;
    }
    public void run() {
        System.out.println("_0003_LongestSubstringWithoutRepeatingCharacters: ");
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
