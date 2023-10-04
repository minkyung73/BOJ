import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1259 {
    // 팰린드롬수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "1";

        while (true) {
            int flag = 0;
            str = br.readLine();
            if(str.equals("0")) break;

            int l = 0, r = str.length()-1;
            while (l < r) {
//                System.out.println(l + " " + r);
//                System.out.println(str.charAt(l) + " " + str.charAt(r));
                if(str.charAt(l) != str.charAt(r)) {
                    flag = 1;
                    break;
                }
                else {
                    l++;
                    r--;
                }
            }

            if(flag == 1) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
