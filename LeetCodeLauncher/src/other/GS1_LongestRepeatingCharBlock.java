package other;

public class GS1_LongestRepeatingCharBlock {

    //we need to catch max size of substring with same repeating letter
    //we do not need to store every substring we find
    //left right pointers - sliding window
    //when right eaches end we return max
    //when left == right we recount max and move right
    //when left != right we move left
    // (eventually it will point to the same letter as right - we wont get stuck)
    public String longestRepeatingCharBlock(String s){
        int max = 1;
        int index = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(left == right){
                right++;
            }
            else if(s.charAt(left) == s.charAt(right)){
                var diff = right - left + 1;
                if(diff > max) {
                    max = diff;
                    index = left;
                }
                right++;
            }
            else {
                left = right;
            }
        }

        return s.substring(index, index + max);
    }
    public void run() {
        System.out.println("GS1_LongestRepeatingCharBlock: ");
        System.out.println("Expected: bbbb   Actual:" + longestRepeatingCharBlock("AAZZZbbbbCAACC"));
        System.out.println("Expected: bbbbb   Actual:" + longestRepeatingCharBlock("AAZZZZAZZbbbbbCAACC"));
    }
}
