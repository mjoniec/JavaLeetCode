package easyString;

public class _0551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        var tab = s.toCharArray();
        int absence = 0;
        int lastLateStream = 0;
        for(var c : tab){
            if(c != 'L') lastLateStream = 0;
            if(c == 'L') lastLateStream++;
            if(c == 'A') absence++;
            if(absence >= 2 || lastLateStream >=3) return false;
        }
        return true;
    }

    public void run() {
        System.out.println("_0551_StudentAttendanceRecordI: ");
        System.out.println("Expected true  Actual " + checkRecord("PPALLP"));
        System.out.println("Expected false Actual " + checkRecord("PPALLL"));
    }
}
