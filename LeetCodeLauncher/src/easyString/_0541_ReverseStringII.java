package easyString;

public class _0541_ReverseStringII {
    public String reverseStr(String s, int k) {
        var tab = s.toCharArray();
        int index = 0;

        while(index+k-1 < s.length()){
            reverse(tab, index, index+k-1);
            index += 2*k;
        }

        int leftover = s.length() - index;
        if(leftover < k) reverse(tab, index, index + leftover - 1);
        if(leftover >= k && leftover < 2*k) reverse(tab, index, index + k - 1);

        return new String(tab);
    }

    private void reverse(char[] tab, int i, int j){
        for(; i < j; i++, j--) {
            var c = tab[i];
            tab[i] = tab[j];
            tab[j] = c;
        }
    }

    public void run() {
        System.out.println("_0541_ReverseStringII: ");
        System.out.println("Expected: ba cd   Actual:" + reverseStr("abcd", 2));
        System.out.println("Expected: ba cd fe g   Actual:" + reverseStr("abcdefg", 2));
        System.out.println("Expected: dcba   Actual:" + reverseStr("abcd", 4));
        System.out.println("Expected: gfedcba   Actual:" + reverseStr("abcdefg", 8));
        System.out.println("Expected: fdcqkmxwholhytmhafpesaentdvxginrjlyqzyh ehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql lgsqddebemjanqcqnfkjmi   Actual:" + reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
//"hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql imjkfnqcqnajmebeddqsgl"
//39
//fdcqkmxwholhytmhafpesaentdvxginrjlyqzyh ehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql imjkfnqcqnajmebeddqsgl
//fdcqkmxwholhytmhafpesaentdvxginrjlyqzyh ehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjql lgsqddebemjanqcqnfkjmi

    }
}
