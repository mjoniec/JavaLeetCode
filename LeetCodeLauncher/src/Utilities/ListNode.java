package Utilities;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static int[] NodesToArray(ListNode node){
        var list = new ArrayList<Integer>();

        while (node != null){
            list.add(node.val);
            node = node.next;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
