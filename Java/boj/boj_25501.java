package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_25501 {

    static int cnt = 0;
    public static void main(String[] args) {
        // 재귀의 귀재

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> palindromes = new ArrayList<>();
        for(int i=0 ; i<N ; i++) {
            String palindrome = sc.next();
            palindromes.add(palindrome);
        }

        // recursion
        for (String palindrome : palindromes) {
            cnt = 0;
            int result = recur(palindrome, 0, palindrome.length()-1);
            System.out.println(result + " " + cnt);
        }

    }

    public static int recur(String palindrome, int l, int r) {
        cnt++;

        if (l>=r) return 1;
        else if(palindrome.charAt(l) != palindrome.charAt(r)) return 0;
        else return recur(palindrome, l+1, r-1);
    }
}
