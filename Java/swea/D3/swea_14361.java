package swea.D3;

import java.io.IOException;
import java.util.Scanner;

public class swea_14361 {
    // 숫자가 같은 배수

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            int n = sc.nextInt();
            if(f(n)) sb.append("#" + (i+1) + " possible\n");
            else sb.append("#" + (i+1) + " impossible\n");
        }
        System.out.println(sb);
    }

    public static boolean f(int n) {
        String str_n = String.valueOf(n);
        int len = str_n.length();
        int temp = n * 2;
        boolean flag;

        while (String.valueOf(temp).length() == len) {
            flag = true;
            String str_temp = String.valueOf(temp);

            for(int i=0 ; i<str_temp.length() ; i++) {
                String s = String.valueOf(str_temp.charAt(i));

                if(!str_n.contains(s)) {
                    flag = false;
                    break;
                }
            }

            if(flag) return true;

            temp += n;
        }

        return false;
    }
}
