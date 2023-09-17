import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1158 {
    public static void main(String[] args) throws IOException {
        // 요세푸스 문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
;
        List<Integer> queue = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0 ; i<n ; i++) queue.add(i+1);

        int idx = k-1;
        while (!queue.isEmpty()) {
//            System.out.println(queue);
            result.add(queue.remove(idx));
            idx += k-1;
            if(!queue.isEmpty() && idx >= queue.size())
                idx = idx % queue.size();
        }

        System.out.print("<");
        for(int i=0 ; i<result.size() ; i++) {
            System.out.print(result.get(i));
            if(i != result.size()-1) System.out.print(", ");
        }
        System.out.print(">");
    }
}
