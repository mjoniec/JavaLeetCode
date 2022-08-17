package easyString;

public class _0014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        var shortestSize = getShortestPrefixSize(strs);
        var max = 0;

        for(int i=0; i<shortestSize; i++){
            if(areAllCharsEqualAtIndex(i, strs)){
                max++;
            }
            else {
                break;
            }
        }

        return strs[0].substring(0, max);
    }

    private boolean areAllCharsEqualAtIndex(int index, String[] strs){
        for (int i = 1; i < strs.length; i++) {
            if (strs[i-1].toCharArray()[index] != strs[i].toCharArray()[index]) {
                return false;
            }
        }

        return true;
    }

    private int getShortestPrefixSize(String[] strs){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            }
        }

        return min;
    }

    public void run() {
        System.out.println("_0014_LongestCommonPrefix: ");
        System.out.println("Input: [flower,flow,flight] Expected: fl Actual:"
                + longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
