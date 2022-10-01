package mediumString;

import java.util.*;

public class _0017_LetterCombinationsPhoneNumber {
    private final List<String> map = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    public List<String> letterCombinations(String digits) {
        Queue<String> queue = new LinkedList<>();
        for(var c : digits.toCharArray()){
            if(queue.isEmpty())
                for (var letter : map.get(Character.getNumericValue(c)).toCharArray())
                    queue.add("" + letter);
            else {
                var size = queue.size();
                while(size-->0){
                    var s = queue.remove();
                    for (var letter : map.get(Character.getNumericValue(c)).toCharArray())
                        queue.add(s + letter);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public void run() {
        System.out.println("_0017_LetterCombinationsPhoneNumber: ");
        System.out.println("Expected \"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"  Actual: "+letterCombinations("23"));
        System.out.println("Expected []  Actual: "+letterCombinations(""));
        System.out.println("Expected [\"a\",\"b\",\"c\"]  Actual: "+letterCombinations("2"));
    }
}
