import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_15829 {
    // Hashing

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        BigInteger sum = new BigInteger("0");
        for(int i=0 ; i<str.length() ; i++) {
            BigInteger a = BigInteger.valueOf(str.charAt(i)-97+1);
            BigInteger m = BigInteger.valueOf(31).pow(i);
            sum = sum.add(a.multiply(m));
        }
        BigInteger result = sum.mod(BigInteger.valueOf(1234567891));
        System.out.println(result);
    }
}
