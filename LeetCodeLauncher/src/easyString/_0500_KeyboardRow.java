package easyString;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _0500_KeyboardRow {
    public String[] findWords(String[] words) {
        return Arrays.stream(words)
                .filter(word->isTypeable(word))
                .toArray(String[]::new);
    }

    private boolean isTypeable(String s){
        var chars = s.toCharArray();
        var row1 = "QWERTYUIOPqwertyuiop".chars().mapToObj(c->(char)c).collect(Collectors.toList());
        var row2 = "ASDFGHJKLasdfghjkl".chars().mapToObj(c->(char)c).collect(Collectors.toList());
        var row3 = "ZXCVBNMzxcvbnm".chars().mapToObj(c->(char)c).collect(Collectors.toList());
        boolean match = true;
        for(var c : chars) if(row1.stream().noneMatch(r->r==c)) match = false;
        if(match) return true;
        match = true;
        for(var c : chars) if(row2.stream().noneMatch(r->r==c)) match = false;
        if(match) return true;
        match = true;
        for(var c : chars) if(row3.stream().noneMatch(r->r==c)) match = false;
        return match ? true : false;
    }

    public void run() {
        System.out.println("_0500_KeyboardRow: ");
        System.out.println("Expected: [\"Alaska\",\"Dad\"]  Actual:" + Arrays.toString(findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
    }
}
