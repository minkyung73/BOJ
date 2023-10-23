import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2072 {
    // 홀수만 더하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int j=0 ; j<10 ; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if(temp % 2 == 1) sum += temp;
            }

            sb.append("#" + (i+1) + " " + sum + "\n");
        }

        System.out.println(sb);
    }
}
