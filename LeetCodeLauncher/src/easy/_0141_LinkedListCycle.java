package easy;

public class _0141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        return false;
    }

    public void run() {
        System.out.println("_0141_LinkedListCycle");
        System.out.println("Given: [3,2,0,-4] Expected: true Actual: "
                + hasCycle(prepareTestNodes()));
    }

    public ListNode prepareTestNodes(){
        var n4 = new ListNode(-4);

        var n0 = new ListNode(1, n4);
        var n2 = new ListNode(2, n0);
        var n3 = new ListNode(3, n2);

        //cycle to be detected
        n4.next = n2;

        return n3;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
