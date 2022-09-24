package easyString;

public class _0541_ReverseStringII {
    public String reverseStr(String s, int k) {
        var tab = s.toCharArray();
        int index = 0;

        while(index + 2*k <= s.length()){
            reverse(tab, index, index+k);
            index+=2*k;
        }

        int leftover = s.length() - index;
        if(leftover < k) reverse(tab, index, leftover);
        if(leftover >= k && leftover < 2*k) reverse(tab, index, index+k);

        return new String(tab);
    }

    private void reverse(char[] tab, int i, int k){
        int mid = (k - i) / 2;
        for(int j = k-1; i+mid<k; i++, j--) {
            var c = tab[i];
            tab[i] = tab[j];
            tab[j] = c;
        }
    }

    public void run() {
        System.out.println("_0541_ReverseStringII: ");
        System.out.println("Expected: bacd   Actual:" + reverseStr("abcd", 2));
        System.out.println("Expected: bacd feg   Actual:" + reverseStr("abcdefg", 2));
        System.out.println("Expected: dcba   Actual:" + reverseStr("abcd", 4));
        System.out.println("Expected: gfed cba   Actual:" + reverseStr("abcdefg", 8));
    }
}
