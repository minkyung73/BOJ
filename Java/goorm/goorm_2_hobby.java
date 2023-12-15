package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class goorm_2_hobby {
    // 구름이의 취미

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long MOD = 1000000007;
        long res = n * (n+1) / 2 % MOD;
        res = res * res % MOD;

        System.out.println(res);
    }
}
