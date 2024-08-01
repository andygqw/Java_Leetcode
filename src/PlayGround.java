import java.util.Scanner;

public class PlayGround implements Solution{


    @Override
    public void test() {


        ListNode node1 = new ListNode(1);
        ListNode node2 = node1;

        node2.val = 13;

        System.out.println(node1.val);

        ListNode node3 = new ListNode(node1);

        node3.val = 14;

        System.out.println(node1.val);
        System.out.println(node2.val);
        System.out.println(node3.val);
    }
}