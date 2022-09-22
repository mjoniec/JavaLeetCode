package other;

import java.util.*;

//optimal sum of 2 elements, one from each given list
// equal or as close as possible to given optimal sum
//once best pair is chosen, search for another pairs that equal that number and return them all
//if some pair would sum less do not include it - leftover elements
//element is a vector - first element is id another is value - value is to be added
public class AM4_OptimalPairs {


//    public int[][]findOptimalPairs(int optimalSum, int[][] array1, int[][] array2){
//        var map1 = new HashMap<Integer, Integer>();
//        var map2 = new HashMap<Integer, Integer>();
//        var list = new ArrayList<int[]>();
//
//        for (int[] a : array1) {
//            map1.put(a[0], a[1]);
//        }
//
//        for (int[] a : array2) {
//            map2.put(a[0], a[1]);
//        }
//
//        var firstOptimalPair = getLargestMatchingPair(optimalSum, map1, map2);
//        var optimalSumFound = firstOptimalPair[0];
//
//        list.add(new int[]{firstOptimalPair[1], firstOptimalPair[2]});
//        map1.remove(firstOptimalPair[1]);
//        map2.remove(firstOptimalPair[2]);
//
//        while(true) {
//            var optimalPair = getMatchingPair(optimalSumFound, map1, map2);
//
//            if(optimalPair.length>0){
//                list.add(new int[]{optimalPair[0], optimalPair[1]});
//                map1.remove(optimalPair[0]);
//                map2.remove(optimalPair[1]);
//            }
//            else{
//                break;
//            }
//        }
//
//        int[][] result = new int[list.size()][2];
//
//        return list.toArray(result);
//    }
//
//    private int [] getLargestMatchingPair(int optimalSum, HashMap<Integer, Integer>map1, HashMap<Integer, Integer>map2){
//        var candidateKey1 = 0;
//        var candidateKey2 = 0;
//        var candidateSum = 0;
//        for (int key1 : map1.keySet()){
//            for (int key2 : map2.keySet()){
//                var sum = map1.get(key1) + map2.get(key2);
//                if(sum > candidateSum && sum <= optimalSum){
//                    candidateSum = sum;
//                    candidateKey1 = key1;
//                    candidateKey2 = key2;
//                    if(sum == optimalSum){
//                        return new int[] {candidateSum, candidateKey1, candidateKey2};
//                    }
//                }
//            }
//        }
//
//        return new int[] {candidateSum, candidateKey1, candidateKey2};
//    }
//
//    private int [] getMatchingPair(int optimalSum, HashMap<Integer, Integer>map1, HashMap<Integer, Integer>map2){
//        for (int key1 : map1.keySet()) {
//            for (int key2 : map2.keySet()) {
//                var sum = map1.get(key1) + map2.get(key2);
//                if (sum == optimalSum) {
//                    return new int[] { key1, key2};
//                }
//            }
//        }
//
//        return new int[] { };
//    }

    //after leetcode training - just compare this and previous code...
    //Talk:
    //need to remember every combination and at the end pick best ones
    //struck(fId, bId, memory)
    //save combinations in List - add only if less than cap
    //order list by cap desc
    //pick first (or multiple firsts)
    public List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList, List<List<Integer>> backgroundAppList){
        var list = new ArrayList<App>();

        for(var fApp : foregroundAppList){
            for(var bApp : backgroundAppList){
                if(fApp.get(1) + bApp.get(1) <= deviceCapacity)
                    list.add(new App(fApp.get(0), bApp.get(0), fApp.get(1) + bApp.get(1)));
            }
        }

        Collections.sort(list, new Comparator<App>() {
            @Override
            public int compare(App o1, App o2) {
                return o1.Mem > o2.Mem ? -1 : 1;
            }
        });

        var optimalMaxSum = list.get(0).Mem;
        List<List<Integer>> outList = new ArrayList<>();

        while(list.get(0).Mem == optimalMaxSum){
            outList.add(new ArrayList<Integer>(Arrays.asList(list.get(0).Fid, list.get(0).Bid)));
            list.remove(0);
        }

        return outList;
    }

    class App{
        public int Fid;
        public int Bid;
        public int Mem;

        public App(int fid, int bid, int mem){
            Fid = fid;
            Bid = bid;
            Mem = mem;
        }
    }
    public void run(){
        System.out.println("OptimalPairs: ");

        List<Integer> listA = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> listB = new ArrayList<>(Arrays.asList(2,4));
        List<Integer> listC = new ArrayList<>(Arrays.asList(3,6));
        List<List<Integer>> list1 = new ArrayList<>(Arrays.asList(listA, listB, listC));
        List<Integer> listD = new ArrayList<>(Arrays.asList(1,2));
        List<List<Integer>> list2 = new ArrayList<>(Arrays.asList(listD));

        System.out.println("Expected [2,1]  Actual:" + optimalUtilization(7, list1, list2));

        list1 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,3)),
                new ArrayList<>(Arrays.asList(2,5)),
                new ArrayList<>(Arrays.asList(3,7)),
                new ArrayList<>(Arrays.asList(4,10))));

        list2 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,2)),
                new ArrayList<>(Arrays.asList(2,3)),
                new ArrayList<>(Arrays.asList(3,4)),
                new ArrayList<>(Arrays.asList(4,5))));

        System.out.println("Expected [2,4],[3,2]  Actual:" + optimalUtilization(10, list1, list2));
    }
}
