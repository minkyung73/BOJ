import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_1676 {
    // 팩토리얼 0의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger sum = new BigInteger("1");
        boolean flag = n == 0;

        while (n > 1) {
            sum = sum.multiply(BigInteger.valueOf(n));
            n--;
        }

        String str = String.valueOf(sum);
        int cnt = 0;
        for(int i = str.length()-1 ; i>= 0 ; i--) {
            if (!str.contains("0")) break;

            if(str.charAt(i) == '0') cnt++;
            else break;
        }

        System.out.println(cnt);
    }
}
