package easyString;

public class _0067_AddBinary {
    public String addBinary(String a, String b) {
        String shorter, longer;
        StringBuilder stringBuilder = new StringBuilder("");

        if(a.length() >= b.length()){
            longer = a;
            shorter = b;
        }
        else{
            longer = b;
            shorter = a;
        }

        var carry = '0';

        for(int i = shorter.length()-1; i>=0; i--){
            var counter = 0;
            if(longer.charAt(i) == '1') counter++;
            if(shorter.charAt(i) == '1') counter++;
            if(carry == '1') counter++;

            if(counter == 3){
                carry = '1';
                stringBuilder.append('1');
            }
            else if(counter == 2){
                carry = '1';
                stringBuilder.append('0');
            }
            else if(counter == 1){
                carry = '0';
                stringBuilder.append('1');
            }
            else if(counter == 0){
                carry = '0';
                stringBuilder.append('0');
            }
        }

        var longerDiff = longer.length() - shorter.length();
        var left = longer.substring(0, longerDiff);

        return left + stringBuilder.reverse();
    }

    public void run() {
        System.out.println("_0067_AddBinary: ");
        System.out.println("Input: a=11, b=1 Expected: 100 Actual:" + addBinary("11", "1"));
        System.out.println("Input: a=1010, b=1011 Expected: 10101 Actual:" + addBinary("1010", "1011"));
    }
}
