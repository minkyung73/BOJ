package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test {
    public static void main(String[] args) throws IOException {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                            {"may", "kein", "brin", "deny"},
                            {"kon", "kain", "may", "coni"}};
        solution(name, yearning, photo);
        Stack<String> stack = new Stack<>();


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
