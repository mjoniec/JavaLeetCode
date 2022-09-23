package easyString;

public class _0434_NumberOfSegmentsInString {
    public int countSegments(String s) {
        var count = 0;
        var tab = s.split(" ");
        for(var t : tab) if(!t.isEmpty()) count++;
        return count;
    }

    public void run() {
        System.out.println("_0434_NumberOfSegmentsInString: ");
        System.out.println("Expected: 0  Actual:" + countSegments(" "));
        System.out.println("Expected: 5  Actual:" + countSegments("Hello, my name is John"));
        System.out.println("Expected: 6  Actual:" + countSegments("\", , , ,        a, eaefa\"\n"));
    }
}
