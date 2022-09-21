package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//optimal sum of 2 elements, one from each given list
// equal or as close as possible to given optimal sum
//once best pair is chosen, search for another pairs that equal that number and return them all
//if some pair would sum less do not include it - leftover elements
//element is a vector - first element is id another is value - value is to be added
public class AM4_OptimalPairs {
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

        var firstOptimalPair = getLargestMatchingPair(optimalSum, map1, map2);
        var optimalSumFound = firstOptimalPair[0];

        list.add(new int[]{firstOptimalPair[1], firstOptimalPair[2]});
        map1.remove(firstOptimalPair[1]);
        map2.remove(firstOptimalPair[2]);

        while(true) {
            var optimalPair = getMatchingPair(optimalSumFound, map1, map2);

            if(optimalPair.length>0){
                list.add(new int[]{optimalPair[0], optimalPair[1]});
                map1.remove(optimalPair[0]);
                map2.remove(optimalPair[1]);
            }
            else{
                break;
            }
        }

        int[][] result = new int[list.size()][2];

        return list.toArray(result);
    }

    private int [] getLargestMatchingPair(int optimalSum, HashMap<Integer, Integer>map1, HashMap<Integer, Integer>map2){
        var candidateKey1 = 0;
        var candidateKey2 = 0;
        var candidateSum = 0;
        for (int key1 : map1.keySet()){
            for (int key2 : map2.keySet()){
                var sum = map1.get(key1) + map2.get(key2);
                if(sum > candidateSum && sum <= optimalSum){
                    candidateSum = sum;
                    candidateKey1 = key1;
                    candidateKey2 = key2;
                    if(sum == optimalSum){
                        return new int[] {candidateSum, candidateKey1, candidateKey2};
                    }
                }
            }
        }

        return new int[] {candidateSum, candidateKey1, candidateKey2};
    }

    private int [] getMatchingPair(int optimalSum, HashMap<Integer, Integer>map1, HashMap<Integer, Integer>map2){
        for (int key1 : map1.keySet()) {
            for (int key2 : map2.keySet()) {
                var sum = map1.get(key1) + map2.get(key2);
                if (sum == optimalSum) {
                    return new int[] { key1, key2};
                }
            }
        }

        return new int[] { };
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
