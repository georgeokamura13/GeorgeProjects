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
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        while(current != null) {

            boolean isDuplicate = false;
            while(current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
                isDuplicate = true;
            }

            if(isDuplicate) {
                if(prev == null) {
                    head = current.next;
                }
                else {
                    prev.next = current.next;
                }
            }
            else{
                prev = current;
            }

            current = current.next;
        }

        return head;
    }

    public static void iterateLinkedList(ListNode head) {

        System.out.print("[");
        if(head == null) {
            System.out.println("]");
            return;
        }

        ListNode current = head;

        while(current.next != null) {
            System.out.print(current.val + ",");
            current = current.next;
        }

        System.out.println(current.val + "]");

    }

    public static ListNode insert(ListNode head, int val) {

        ListNode insertingNode = new ListNode(val);

        if(head == null) {
            head = insertingNode;
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while(current != null && current.val < insertingNode.val) {
            prev = current;
            current = current.next;
        }

        if(prev == null) {
            insertingNode.next = current;
            head = insertingNode;
        }
        else {
            insertingNode.next = prev.next;
            prev.next = insertingNode;
        }

        return head;
    }

    public static void main(String[] args) {

        System.out.println("Testing with [1,2,2,3,3,4,5]: ");
        ListNode head = new ListNode(1);
        head = insert(head, 2);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        iterateLinkedList(head);

        head = deleteDuplicates(head);
        iterateLinkedList(head);

        System.out.println("\nTesting with [1,1,2,2]: ");
        head = new ListNode(1);
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 2);
        iterateLinkedList(head);

        head = deleteDuplicates(head);
        iterateLinkedList(head);

        System.out.println("\nTesting with [1,1]: ");
        head = new ListNode(1);
        head = insert(head, 1);
        iterateLinkedList(head);

        head = deleteDuplicates(head);
        iterateLinkedList(head);

        System.out.println("\nTesting with [1]: ");
        head = new ListNode(1);
        iterateLinkedList(head);

        head = deleteDuplicates(head);
        iterateLinkedList(head);
    }
}