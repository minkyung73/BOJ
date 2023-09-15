import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class goorm_3_bbuyo {

    private static int n, m;
    private static String str;

    public static boolean bbuyo() {
        int flag = 1;

        for(int i=0 ; i<=str.length()-m ; i++) {
            int s = i;
            for(int j=i+1 ; j<str.length() ; j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    flag++;
                } else {
                    s = j;
                    break;
                }
            }

            if(flag >= m) {
                str = str.substring(0, i) + str.substring(s);
                System.out.println(str);
                flag = 1;
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        // 뿌요뿌요

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        str = br.readLine();

        while (true) {
            boolean result = bbuyo();
            if(!result) break;
        }

        if(str.length() == 0) System.out.println("CLEAR!");
        else System.out.println(str);
    }
}
