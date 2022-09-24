package easyString;

import java.util.ArrayList;

public class _0482_LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        var tab = s.split("-");
        var chars = String.join("", tab).toCharArray();
        for(int i = 0; i<chars.length; i++)
            if(chars[i]>=97&&chars[i]<=122)
                chars[i] = (char)(chars[i]-32);

        s = new String(chars);
        var list = new ArrayList<String>();
        if(k>=s.length()) list.add(s);
        else{
            var i = s.length()-k;
            while(i > 0){
                list.add(s.substring(i, i+k));
                if(i<=k)break;
                i-=k;
            }
            list.add(s.substring(0, i));
        }
        var sb = new StringBuilder();
        for(int j = list.size()-1; j>0; j--){
            sb.append(list.get(j));
            sb.append("-");
        }
        sb.append(list.get(0));
        return sb.toString();
    }

    public void run() {
        System.out.println("_0482_LicenseKeyFormatting: ");
        System.out.println("Expected: 5F3Z-2E9W   Actual:" + licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println("Expected: 2-5G-3J   Actual:" + licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println("Expected: R   Actual:" + licenseKeyFormatting("r", 1));
    }
}
