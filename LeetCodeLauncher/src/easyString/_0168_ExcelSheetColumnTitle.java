package easyString;

public class _0168_ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        String s = "";
        while(columnNumber-- > 0){
            s += (char) ('A' + columnNumber % 26);
            columnNumber /= 26;
        }
        return new StringBuilder(s).reverse().toString();
    }

    public void run() {
        System.out.println("_0168_ExcelSheetColumnTitle: ");
        System.out.println("Expected: AB Actual:" + convertToTitle(28));
        System.out.println("Expected: ZY  Actual:" + convertToTitle(701));
    }
}
