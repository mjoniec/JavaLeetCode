package easyGraph;

import java.util.*;

public class _0997_FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;

        //people ids excluding trust
        var people = new HashSet<Integer>();

        //truster >> trusts >> trustee
        //trustees Set - incoming arrows (whom a person is trusted by)
        //trusters Set - outgoing arrows (whom a person trust)
        Map<Integer, Set<Integer>> trusters = new HashMap<>();
        Map<Integer, Set<Integer>> trustees = new HashMap<>();

        for (int[] t : trust){
            people.add(t[0]);
            people.add(t[1]);
            trusters.computeIfAbsent(t[0], p -> new HashSet<>());
            trusters.computeIfAbsent(t[1], p -> new HashSet<>());
            trustees.computeIfAbsent(t[0], p -> new HashSet<>());
            trustees.computeIfAbsent(t[1], p -> new HashSet<>());
        }

        //build trust sets
        for (int[] t : trust){
            trusters.get(t[0]).add(t[1]);
            trustees.get(t[1]).add(t[0]);
        }

        for(var trustee : trustees.entrySet()){
            people.remove(trustee.getKey());//people except self

            if(trustee.getValue().equals(people) &&//trusted by all trusters
                trusters.get(trustee.getKey()).size() == 0){//trustee trust no one
                    return trustee.getKey();
            }

            people.add(trustee.getKey());
        }

        return -1;
    }

    public void run() {
        System.out.println("_0997_FindTheTownJudge: ");
        System.out.println("Expected 2   Actual: "
                + findJudge(2, new int[][]{{1,2}}));
        System.out.println("Expected 3   Actual: "
                + findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println("Expected -1   Actual: "
                + findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
    }
}
