package easyLinkedList;

import Utilities.ListNode;
import java.util.ArrayList;

public class _1290_ConvertBinaryNumberInLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        var list = new ArrayList<Integer>();
        ListNode loopNode = head;

        while(loopNode != null){
            for(int i = 0; i<list.size(); i++) list.set(i, list.get(i)*2);
            list.add(loopNode.val);
            loopNode = loopNode.next;
        }

        return list.stream().reduce(0, Integer::sum);
    }

    public void run() {
        System.out.println("_1290_ConvertBinaryNumberInLinkedListToInteger");
        System.out.println("Given: [1,0,1] Expected: 5 Actual: " + getDecimalValue(prepareTestNodes()));
    }

    public ListNode prepareTestNodes(){
        var n3 = new ListNode(1);
        var n2 = new ListNode(0, n3);
        var n1 = new ListNode(1, n2);

        return n1;
    }
}
