package easyString;

import java.util.ArrayList;

public class _0345_ReverseVowelsOfString {
    public String reverseVowels(String s) {
        var vowelsIndexes = new ArrayList<Integer>();
        for(int i = 0; i<s.length(); i++)
            if(isVowel(s.charAt(i))) vowelsIndexes.add(i);

        var tab = s.toCharArray();
        for(int i = 0, j = vowelsIndexes.size()-1; i<vowelsIndexes.size()/2; i++,j--) {
            var c = tab[vowelsIndexes.get(i)];
            tab[vowelsIndexes.get(i)] = tab[vowelsIndexes.get(j)];
            tab[vowelsIndexes.get(j)] = c;
        }
        return new String(tab);
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u' ||
               c == 'A' || c == 'E' ||c == 'I' ||c == 'O' ||c == 'U';
    }

    public void run() {
        System.out.println("_0345_ReverseVowelsOfString: ");
        System.out.println("Expected: ezzazz Actual:" + reverseVowels("azzezz"));
    }
}
