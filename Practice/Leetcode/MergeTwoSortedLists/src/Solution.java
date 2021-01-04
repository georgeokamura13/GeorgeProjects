import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public ListNode append(int value) {

            ListNode curr = this;
            while(curr.next != null) {
                curr = curr.next;
            }

            curr.next = new ListNode(value);
            return this;
        }

        public int[] iterate(ListNode node) {

            int[] result = null;



            return result;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) {
            return null;
        }
        else if(l2 == null) {
            ListNode newNode = new ListNode(l1.val);
            newNode.next = mergeTwoLists(l1.next, l2);
            return newNode;
        }
        else if(l1 == null) {
            ListNode newNode = new ListNode(l2.val);
            newNode.next = mergeTwoLists(l1, l2.next);
            return newNode;
        }

        if(l1.val < l2.val) {
            ListNode newNode = new ListNode(l1.val);
            newNode.next = mergeTwoLists(l1.next, l2);
            return newNode;
        }
        else {
            ListNode newNode = new ListNode(l2.val);
            newNode.next = mergeTwoLists(l1, l2.next);
            return newNode;
        }
    }

    public static void main (String[] args) {

        ListNode list1 = new ListNode(1).append(2).append(4);
        ListNode list2 = new ListNode(1).append(3).append(4);

        ListNode result = mergeTwoLists(list1, list2);

        boolean resultCheck = true;
        int[] expected = new int[]{1, 1, 2, 3, 4, 4};
        for(int i = 0; i < expected.length; i++) {
            if(result == null) {
                resultCheck = false;
                break;
            }

            System.out.println("result.vaL: " + result.val);
            System.out.println("expected[i]: " + expected[i]);
            if(result.val != expected[i]) {
                resultCheck = false;
                break;
            }
            result = result.next;
        }
        if(result != null) {
            resultCheck = false;
        }

        if(resultCheck) {
            System.out.println("Passed!");
        }
        else {
            System.out.println("Failed!");
        }
    }
}