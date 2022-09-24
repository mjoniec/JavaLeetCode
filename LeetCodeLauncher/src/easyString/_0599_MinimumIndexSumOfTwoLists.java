package easyString;

import java.util.*;

public class _0599_MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        var common = new ArrayList<String>();
        for (var s : list1)
            if(Arrays.stream(list2).anyMatch(l->l.equals(s)))
                common.add(s);

        var sums = new HashMap<String, Integer>();
        for(var s : common){
            sums.putIfAbsent(s, getIndex(list1, s) + getIndex(list2, s));
        }

        var min = Integer.MAX_VALUE;
        for(var sum : sums.values()) if(sum < min) min = sum;

        var mins = new ArrayList<String>();
        Iterator iterator = sums.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry pair = (Map.Entry) iterator.next();
            if((int)pair.getValue() == min) mins.add((String) pair.getKey());
        }

        return mins.toArray(new String[mins.size()]);
    }

    private Integer getIndex(String[] list, String s){
        for(int i=0; i<list.length; i++) if (list[i].equals(s)) return i;
        return -1;
    }

    public void run() {
        System.out.println("_0599_MinimumIndexSumOfTwoLists: ");
        System.out.println("Expected: [\"Shogun\"] Actual:" +
                Arrays.toString(findRestaurant(
                        new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                        new String[]{"KFC","Shogun","Burger King"}
                )));
    }
}
