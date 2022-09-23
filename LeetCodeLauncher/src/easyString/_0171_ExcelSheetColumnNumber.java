package easyString;

public class _0171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int n = 0;
        for(int i=0; i<columnTitle.length(); i++)
            n += (columnTitle.charAt(i) - 'A' + 1) *
                Math.pow(26, (columnTitle.length()-1-i));
        return n;
    }

    public void run() {
        System.out.println("_0171_ExcelSheetColumnNumber: ");
        System.out.println("Expected: 28 Actual:" + titleToNumber("AB"));
        System.out.println("Expected: 701  Actual:" + titleToNumber("ZY"));
    }
}
