public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(ListNode node){

        this.val = node.val;
        this.next = node.next;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}