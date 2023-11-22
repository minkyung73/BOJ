package programmers;

import java.io.IOException;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        String[] name = {"may", "kein333", "kain11", "ra"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                            {"may", "kein", "brin", "deny"},
                            {"kon", "kain", "may", "coni"}};
        solution(name, yearning, photo);
        Stack<String> stack = new Stack<>();

        Arrays.sort(name, (o1, o2) -> o1.length() < o2.length() ? -1 : 1);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        Object[] arr = list.toArray();

        for(int i=0 ; i<arr.length ; i++)
            System.out.println(arr[i]);
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        List<String> name_list = new ArrayList<>(Arrays.asList(name));

        for(int i=0 ; i< photo.length ; i++) {
            for(int j=0 ; j<photo[i].length ; j++) {

            }
        }


        return answer;
    }
}
