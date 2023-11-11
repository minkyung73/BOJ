package swea.D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_1244 {
    // [S/W 문제해결 응용] 2일차 - 최대 상금

    private static int[] arr;
    private static int max, chance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            chance = Integer.parseInt(st.nextToken());

            arr = new int[str.length()];
            for (int j = 0; j < str.length(); j++)
                arr[j] = Integer.parseInt(String.valueOf(str.charAt(j)));

            max = 0;
            if(arr.length < chance)
                chance = arr.length;

            money(0, 0);

            sb.append("#" + (i + 1) + " " + max + "\n");
        }
        System.out.println(sb);
    }

    public static void money(int start, int cnt) {
        if(cnt == chance) {
            StringBuilder result = new StringBuilder();
            for(Integer a : arr)
                result.append(a);
            max = Math.max(max, Integer.parseInt(result.toString()));
            return ;
        }

        for(int i=start ; i < arr.length ; i++) {
            for(int j=i+1 ; j<arr.length ; j++) {
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                money(i, cnt+1);

                // 다시 swap
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

    }
}
