package easyString;

public class _0557_ReverseWordsInStringIII {
    public String reverseWords(String s) {
        var tab = s.split(" ");
        for(int i=0; i<tab.length; i++) tab[i] = reverseString(tab[i]);
        return String.join(" ", tab);
    }

    public String reverseString(String s) {
        var tab = s.toCharArray();
        for(int i = 0, j = tab.length-1; i<tab.length/2; i++,j--) {
            var c = tab[i];
            tab[i] = tab[j];
            tab[j] = c;
        }
        return new String(tab);
    }

    public void run() {
        System.out.println("_0557_ReverseWordsInStringIII: ");
        System.out.println("Expected:s'teL ekat edoCteeL tsetnoc   Actual:" + reverseWords("Let's take LeetCode contest"));
    }
}
