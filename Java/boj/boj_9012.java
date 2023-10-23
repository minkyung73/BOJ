package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_9012 {
    public static void main(String[] args) {
        // 괄호

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<String> parenthesis = new ArrayList<>();
        for(int i=0 ; i<N ; i++) {
            parenthesis.add(sc.nextLine());
        }

        // function call
        for(int i=0 ; i<N ; i++) {
            String result = isParenthesis(parenthesis.get(i));
            System.out.println(result);
        }
    }

    public static String isParenthesis(String str) {
        char[] chars = str.toCharArray();
        int cnt = 0;

        for (char c : chars) {
            if (c == '(') cnt++;
            else if (c == ')') {
                if(cnt == 0) return "NO";
                cnt--;
            }
        }

        if (cnt == 0) return "YES";
        else return "NO";
    }
}
