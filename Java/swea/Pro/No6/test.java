package swea.Pro.No6;

import java.util.*;

public class test {

    public static void main(String[] args) {
        HashSet<Node> set = new HashSet<>();
        set.add(new Node(0, 0, 10));
        set.add(new Node(0, 0, 20));
        set.add(new Node(0, 0, 30));
        set.add(new Node(0, 0, 40));
        Node now = new Node(0, 0, 10);
        System.out.println(set.contains(new Node(0, 0, 10)));
        System.out.println(now.equals(new Node(0, 0, 10)));

        TreeMap<Integer,String> map2 = new TreeMap<>();
        
    }

    public static class Node {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public boolean equals(Object obj) {
            Node object = (Node) obj;
            return this.x == object.x
                    && this.y == object.y
                    && this.num == object.num;
        }
    }
}
