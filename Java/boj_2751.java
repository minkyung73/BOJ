import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj_2751 {
    // 수 정렬하기 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        for(int i=0 ; i<n ; i++) arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr);
        for (Integer v : arr) sb.append(v).append('\n');
        System.out.println(sb);
    }
}
