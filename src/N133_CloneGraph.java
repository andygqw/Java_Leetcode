import java.util.*;

public class N133_CloneGraph implements Solution{

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node root = new Node(1);

    @Override
    public void test(){

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        root.neighbors.add(node2);
        root.neighbors.add(node4);

        node2.neighbors.add(root);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(root);
        node4.neighbors.add(node3);

        Node newNode = cloneGraph(root);

        for(Node node : newNode.neighbors){

            System.out.println(node.val);
        }
    }

    private Node cloneGraph(Node node) {

        if(node == null) return null;

        Deque<Node> queue = new ArrayDeque<Node>();
        Map<Node, Node> map = new HashMap<Node, Node>();

        queue.add(node);

        while(!queue.isEmpty()){

            Node cur = queue.poll();

            if (map.containsKey(cur)){

                break;
            }

            Node newNode = new Node(cur.val);

            for(Node neighbor : cur.neighbors){

                if(map.containsKey(neighbor)){

                    Node temp = map.get(neighbor);
                    newNode.neighbors.add(temp);
                    temp.neighbors.add(newNode);
                    map.put(neighbor, temp);
                }
                else {

                    queue.add(neighbor);
                }
            }
            map.put(cur, newNode);
        }
        return map.get(node);
    }
}
