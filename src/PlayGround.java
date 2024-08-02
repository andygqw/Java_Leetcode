import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

        String str = "Hello From PlayGround";
        Consumer<String> print = s -> System.out.println(s);
        print.accept(str);

        Predicate<String> p1 = s -> s.equals("Hello From PlayGround");
        Predicate<String> p2 = s -> s.equals("Hello");

        System.out.println(p1.test(str));
        System.out.println(p2.test(str));

        System.out.println(str.charAt(0));
    }
}