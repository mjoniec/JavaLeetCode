package easyString;

public class _0067_AddBinary {
    public String addBinary(String a, String b) {
        var stringBuilder = new StringBuilder("");
        var ia = a.length()-1;
        var jb = b.length()-1;
        var carry = '0';

        while(ia>=0 || jb>=0){
            var bit1Counter = 0;
            if(ia>=0 && a.charAt(ia--) == '1') bit1Counter++;
            if(jb>=0 && b.charAt(jb--) == '1') bit1Counter++;
            if(carry == '1') bit1Counter++;

            if(bit1Counter == 3){
                carry = '1';
                stringBuilder.append('1');
            }
            else if(bit1Counter == 2){
                carry = '1';
                stringBuilder.append('0');
            }
            else if(bit1Counter == 1){
                carry = '0';
                stringBuilder.append('1');
            }
            else if(bit1Counter == 0){
                carry = '0';
                stringBuilder.append('0');
            }
        }

        if(carry=='1'){
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    public void run() {
        System.out.println("_0067_AddBinary: ");
        System.out.println("Input: a=11, b=1 Expected: 100 Actual:" + addBinary("11", "1"));
        System.out.println("Input: a=1010, b=1011 Expected: 10101 Actual:" + addBinary("1010", "1011"));
    }
}
