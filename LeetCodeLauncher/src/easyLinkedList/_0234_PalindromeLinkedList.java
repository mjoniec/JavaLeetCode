package easyLinkedList;

import Utilities.ListNode;

import java.util.ArrayList;

public class _0234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        var list = new ArrayList<Integer>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }

        for(int i = 0, j = list.size()-1; i<list.size(); i++, j--){
            if(list.get(i) != list.get(j)) return false;
        }

        return true;
    }

    public void run() {
        System.out.println("_0234_PalindromeLinkedList");
        System.out.println("Given: [1,2,2,1] Expected: true Actual: " +
                isPalindrome(prepareTestNodes()));
        System.out.println("Given: [1,2] Expected: false Actual: " +
                isPalindrome(prepareTestNodes2()));
    }

    public ListNode prepareTestNodes(){
        var n4 = new ListNode(1);
        var n3 = new ListNode(2, n4);
        var n2 = new ListNode(2, n3);
        var n1 = new ListNode(1, n2);
        return n1;
    }

    public ListNode prepareTestNodes2(){
        var n2 = new ListNode(2);
        var n1 = new ListNode(1, n2);
        return n1;
    }
}
