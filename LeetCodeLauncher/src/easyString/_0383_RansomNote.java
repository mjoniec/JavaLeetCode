package easyString;

public class _0383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        var tabR = new int[128];
        var tabM = new int[128];
        for(int i = 0; i<ransomNote.length(); i++) tabR[ransomNote.charAt(i)]++;
        for(int i = 0; i<magazine.length(); i++) tabM[magazine.charAt(i)]++;

        for(int i = 0; i<128; i++)
            if(tabR[i] > 0 && tabR[i] > tabM[i]) return false;

        return true;
    }

    public void run() {
        System.out.println("_0383_RansomNote: ");
        System.out.println("Expected: true  Actual:" + canConstruct("ab", "azzzzbzzz"));
        System.out.println("Expected: false  Actual:" + canConstruct("abb", "azzzzbzzz"));
    }
}
