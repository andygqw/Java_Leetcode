public class N148_SortList implements Solution{

    @Override
    public void test() {

        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(4, node2);

        ListNode result = sortList(head);

        for (; result != null; result = result.next) {

            System.out.println(result.val);
        }
    }

    private ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;




        return head;
    }


    private ListNode recur(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        while (left != null && right != null) {

            if (left.val < right.val) {

                ptr.next = left;
                ptr = left;
                left = left.next;
            }
            else {

                ptr.next = right;
                ptr = right;
                right = right.next;
            }
        }

        ptr.next = left == null ? right : left;
        return dummy.next;
    }
}