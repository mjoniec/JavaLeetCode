package easyDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class _0118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        var one = new ArrayList<Integer>();
        one.add(1);
        list.add(one);

        for(int i = 2; i<=numRows; i++){
            var row = new ArrayList<Integer>();
            for(int j = 0; j<i; j++){
                if(j == 0) row.add(1);
                else if (j == i-1) row.add(1);
                else row.add(list.get(i-2).get(j-1) + list.get(i-2).get(j));
            }
            list.add(row);
        }

        return list;
    }

    public void run() {
        System.out.println("_0118_PascalsTriangle: ");
        System.out.println("Expected: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]   Actual: " + generate(5));
    }
}
