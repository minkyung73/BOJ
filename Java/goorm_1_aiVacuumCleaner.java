import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class goorm_1_aiVacuumCleaner {
    static String vacuum(int abs, int n) {
        if(abs == n) return "YES";
        else if(abs > n) return "NO";
        else {
            if((n - abs)%2 == 0) return "YES";
            else return "NO";
        }
    }

    public static void main(String[] args) throws IOException {
        // 인공지능 청소기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        List<String> result = new ArrayList<>();

        for(int i=0 ; i<t ; i++) {
            String inputLine = br.readLine();
            StringTokenizer st = new StringTokenizer(inputLine);

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int abs = Math.abs(x) + Math.abs(y);
            result.add(vacuum(abs, n)); // function call
        }

        // output
        for(int i=0 ; i<t ; i++)
            System.out.println(result.get(i));
    }
}
