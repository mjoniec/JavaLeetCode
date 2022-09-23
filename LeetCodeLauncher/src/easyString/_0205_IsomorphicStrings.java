package easyString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _0205_IsomorphicStrings {

    //per each char key we store indexes
    //we compare indexes sets of 2 presumably different chars both at index i
    public boolean isIsomorphic(String s, String t) {
        var mapS = new HashMap<Character,Set<Integer>>();
        var mapT = new HashMap<Character,Set<Integer>>();
        for(var i=0; i<s.length(); i++){
            mapS.computeIfAbsent(s.charAt(i), e-> new HashSet<>()).add(i);
            mapT.computeIfAbsent(t.charAt(i), e-> new HashSet<>()).add(i);
        }

        for(var i=0; i<s.length(); i++)
            if(!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))) return false;

        return true;
    }

    public void run() {
        System.out.println("_0205_IsomorphicStrings: ");
        System.out.println("Expected: true Actual:" + isIsomorphic("egg", "add"));
        System.out.println("Expected:false Actual:" + isIsomorphic("egg", "bar"));
        System.out.println("Expected:false Actual:" + isIsomorphic("bbaaab", "aabbab"));
    }
}
