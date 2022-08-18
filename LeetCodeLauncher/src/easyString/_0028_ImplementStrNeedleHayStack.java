package easyString;

public class _0028_ImplementStrNeedleHayStack {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= (haystack.length() - needle.length()); i++){
            var s = haystack.substring(i, i+needle.length());
            if(s.equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public void run() {
        System.out.println("_0028_ImplementStrNeedleHayStack: ");
        System.out.println("Input: hello, ll Expected: 2 Actual:" + strStr("hello", "ll"));
    }
}
