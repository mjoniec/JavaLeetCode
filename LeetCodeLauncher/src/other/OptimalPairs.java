package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//optimal sum of 2 elements, one from each given list
// equal or as close as possible to given optimal sum
//once best pair is chosen, search for another pairs that equal that number and return them all
//if some pair would sum less do not include it - leftover elements
//element is a vector - first element is id another is value - value is to be added
public class OptimalPairs {
    public int[][]findOptimalPairs(int optimalSum, int[][] array1, int[][] array2){
        var map1 = new HashMap<Integer, Integer>();
        var map2 = new HashMap<Integer, Integer>();
        var list = new ArrayList<int[]>();

        for (int[] a : array1) {
            map1.put(a[0], a[1]);
        }

        for (int[] a : array2) {
            map2.put(a[0], a[1]);
        }

        var candidateKey1 = 0;
        var candidateKey2 = 0;
        var candidateSum = 0;

        outerloop1:
        for (int key1 : map1.keySet()){
            for (int key2 : map2.keySet()){
                var sum = map1.get(key1) + map2.get(key2);
                if(sum > candidateSum && sum <= optimalSum){
                    candidateSum = sum;
                    candidateKey1 = key1;
                    candidateKey2 = key2;
                    if(sum == optimalSum){
                        break outerloop1;
                    }
                }
            }
        }

        list.add(new int[]{candidateKey1, candidateKey2});
        map1.remove(candidateKey1);
        map2.remove(candidateKey2);

        var pairFound = false;

        do {
            pairFound = false;
            outerloop2:
            for (int key1 : map1.keySet()) {
                for (int key2 : map2.keySet()) {
                    var sum = map1.get(key1) + map2.get(key2);
                    if (sum == candidateSum) {
                        candidateKey1 = key1;
                        candidateKey2 = key2;
                        pairFound = true;
                        break outerloop2;
                    }
                }
            }
            if(pairFound){
                list.add(new int[]{candidateKey1, candidateKey2});
                map1.remove(candidateKey1);
                map2.remove(candidateKey2);
            }
        }
        while(pairFound);

        int[][] result = new int[list.size()][2];

        return list.toArray(result);
    }
    public void run(){
        System.out.println("OptimalPairs: ");

        var t1 = findOptimalPairs(7, new int[][]{{1,2},{2,4},{3,6}}, new int[][]{{1,2}});
        System.out.println(Arrays.deepToString(t1));

        var t2 = findOptimalPairs(
                10,
                new int[][]{{1,3}, {2,5}, {3,7}, {4,10}},
                new int[][]{{1,2}, {2,3}, {3,4}, {4,5}});
        System.out.println(Arrays.deepToString(t2));
    }
}
