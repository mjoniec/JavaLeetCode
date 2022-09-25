package other;

import java.util.ArrayList;

public class GS2_SpaceBetweenWordsMid {
    //old
    public int FindLangestSpaceBetweenMiddleOfWords(String s){
        int max = 0;
        var words = s.split(" ");

        for(int i=0; i+1<words.length;){
            var j = 1;
            while(i+j<words.length && words[i+j].isEmpty()){
                j++;
            }

            var space = (words[i].length() + words[i+j].length()) / 2 + j;
            if(space>max){
                max=space;
            }
            i+=j;
        }

        return max;
    }

    //we need to define:
    //word - chunk of chars excluding space ' '
    //left and right index - mid countable and words comparable across one s
    //word mid - aaZXa>>Z  aaXa>X (

    //spliting s will loose index data
    // - we need to determine where words are
    // - store words index data - will get rid of spaces
    //
    // comparing words assumes left to right index order

    class Word{
        int left;
        int right;
        Word(int left, int right){
            this.left = left;
            this.right = right;
        }

        int getMid() {
            int mid = left + (right-left)/2;
            if((right-left+1)%2 == 0) mid++;
            return mid;
        }
    }
    public int longestDistanceBetweenWordsMid(String s){
        var words = new ArrayList<Word>();
        var left = -1;
        for(int i = 0; i<s.length(); i++) {
            //determine if we look for word beginning or end
            if(left<0) {
                if(s.charAt(i) != ' ') left = i;
            }
            else {
                if(s.charAt(i) == ' ') {
                    words.add(new Word(left, i-1));
                    left = -1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i<words.size()-1; i++){
            var distance = words.get(i+1).getMid() - words.get(i).getMid() - 1;
            if(distance > max) max = distance;
        }

        return max;
    }

    public void run() {
        System.out.println("SpaceBetweenWordsMiddle: ");
        System.out.println("Expected: 2 Actual: " +longestDistanceBetweenWordsMid("aa bb ccc"));
        System.out.println("Expected: 2 Actual: " +longestDistanceBetweenWordsMid(" aa bb ccc"));
        System.out.println("Expected: 6 Actual: " + longestDistanceBetweenWordsMid("  aa     ccc a "));

        //old - does not work properly
        System.out.println("Expected: 2 Actual: " +FindLangestSpaceBetweenMiddleOfWords("aa bb ccc"));
        System.out.println("Expected: 2 Actual: " +FindLangestSpaceBetweenMiddleOfWords(" aa bb ccc"));
        System.out.println("Expected: 6 Actual: " + FindLangestSpaceBetweenMiddleOfWords("  aa     ccc a "));
    }
}
