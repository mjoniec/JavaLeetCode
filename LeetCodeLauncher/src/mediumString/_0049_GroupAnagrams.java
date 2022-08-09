package mediumString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        var groups = new ArrayList<Group>();

        for(var s : strs){
            var ascii = countAscii(s);
            var groupFound = false;

            for(var group : groups){
                if(areAsciiEqual(group.asciiTab, ascii)){
                    group.Anagrams.add(s);
                    groupFound = true;
                    break;
                }
            }

            if(!groupFound){
                var newGroup = new Group();
                newGroup.asciiTab = countAscii(s);
                newGroup.Anagrams.add(s);
                groups.add(newGroup);
            }
        }

        List<List<String>> list = new ArrayList<List<String>>();

        for(var group : groups){
            list.add(group.Anagrams);
        }

        return list;
    }

    public void run() {
        System.out.println("_0049_GroupAnagrams: ");
        System.out.println("Input: [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"] " +
                "Expected: [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]" +
                " Actual:" );

        var list = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(Arrays.deepToString(list.toArray()));

        list = groupAnagrams(new String[]{""});
        System.out.println(Arrays.deepToString(list.toArray()));

        list = groupAnagrams(new String[]{"a"});
        System.out.println(Arrays.deepToString(list.toArray()));
    }

    private boolean areAsciiEqual(int[] asciiTab1, int[] asciiTab2){
        int i = 0;
        while (i < 128){
            if(asciiTab1[i] != asciiTab2[i]) {
                return false;
            }
            i++;
        }

        return true;
    }

    private int[] countAscii(String s){
        int[] asciiTab = new int[128];

        for(int i =0; i<s.length(); i++){
            asciiTab[s.charAt(i)]++;
        }

        return asciiTab;
    }

    private class Group{
        public ArrayList<String> Anagrams;
        public int[] asciiTab = new int[128];

        private Group(){
            Anagrams = new ArrayList<>();
        }
    }
}
