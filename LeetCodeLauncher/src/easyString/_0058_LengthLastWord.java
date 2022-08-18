package easyString;

public class _0058_LengthLastWord {
    public int lengthOfLastWord(String s) {
        var tab = s.split(" ");
        return tab[tab.length-1].length();
    }

    public void run() {
        System.out.println("_0058_LengthLastWord: ");
        System.out.println("Input: Hello World   Expected: 5 Actual:" + lengthOfLastWord("Hello World"));
    }
}
