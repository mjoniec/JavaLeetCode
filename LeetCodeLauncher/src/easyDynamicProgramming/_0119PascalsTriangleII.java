package easyDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class _0119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        var one = new ArrayList<Integer>();
        one.add(1);
        list.add(one);

        for(int i = 1; i<=rowIndex; i++){
            var row = new ArrayList<Integer>();
            for(int j = 0; j<=i; j++){
                if(j == 0) row.add(1);
                else if (j == i) row.add(1);
                else row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            list.add(row);
        }

        return list.get(rowIndex);
    }

    public void run() {
        System.out.println("_0119PascalsTriangleII: ");
        System.out.println("Expected: [1,4,6,4,1]   Actual: " + getRow(4));
    }
}
