public class N148_SortList {

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





        return head;
    }
}