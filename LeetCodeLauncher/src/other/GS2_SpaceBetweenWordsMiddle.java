package other;

public class GS2_SpaceBetweenWordsMiddle {
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
    public void run() {
        System.out.println("SpaceBetweenWordsMiddle: ");
        System.out.println("Expected: 6 Actual: " +FindLangestSpaceBetweenMiddleOfWords("aaaa bbbb cccccc"));
        System.out.println("Expected: 9 Actual: " + FindLangestSpaceBetweenMiddleOfWords("aaaa     bbbb cccccc"));
    }
}
