package test;

import java.util.*;

public class Main {

    static HashSet<String> set = new HashSet<>();
    static HashMap<String, Integer> map =  new HashMap<>();
    static String[] phone_book = {"12","123","1235","567","88"};
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
                else return Integer.compare(o1.length(), o2.length());
            }
        });

        System.out.println(Arrays.toString(phone_book));

//        phone_book[0].compareTo(phone_book[1])
    }

    public static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
