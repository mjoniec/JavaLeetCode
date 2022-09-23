package easyString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _0290_WordPattern {
    //interesting mesh of problems 205 and 1971
    //the concrete info we have is number of spaces between words in s - number of words
    //pattern isnt clear right from the start - aaaa could mean key 'a' or 'aa'
    //so it could cover both 'dog dog' and 'dog dog dog dog'
    //spaces could help us determine the division of patterns into right amout of keys-substring
    //text does not say if keys in pattern are all the same length themselves
    // 'abba' could cover "dog cat cat dog" but also "dog cat dog" if keys are 'a' 'bb' and not 'a' 'b'
    //example 1 suggest it should be considered 'a' 'b'
    public boolean wordPattern(String pattern, String s) {
        var wordsCount = s.split(" ").length;
        if(pattern.length() != wordsCount) return false;//assumes key is 1 char long
        var words = s.split(" ");
        var mapPatternKeys = new HashMap<Character, Set<Integer>>();
        var mapWords = new HashMap<String,Set<Integer>>();

        for(int i = 0; i<pattern.length(); i++){
            mapPatternKeys.computeIfAbsent(pattern.charAt(i), e-> new HashSet<>()).add(i);
            mapWords.computeIfAbsent(words[i], e-> new HashSet<>()).add(i);
        }

        for(var i=0; i<pattern.length(); i++)
            if(!mapPatternKeys.get(pattern.charAt(i))
                    .equals(mapWords.get(words[i]))) return false;

        return true;
    }

    public void run() {
        System.out.println("_0290_WordPattern: ");
        System.out.println("Expected true   Actual: " + wordPattern("abba", "dog cat cat dog"));
        System.out.println("Expected false   Actual: " + wordPattern("abba", "dog cat cat fish"));
    }
}
