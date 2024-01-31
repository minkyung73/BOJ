package swea.D2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1974 {
    // 스도쿠 검증
    private static List<List<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            arr = new ArrayList<>();
            for(int j=0 ; j<9 ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                arr.add(new ArrayList<>());
                for(int k=0 ; k<9 ; k++) {
                    arr.get(j).add(Integer.parseInt(st.nextToken()));
                }
            }

            int result = 1;
            for(int j=0 ; j<9 ; j++) {
                if(!(width(j) == 1 && length(j) == 1 && square(j/3, (j%3)*3) == 1)) {
                    result = 0;
                    break;
                }
            }
            sb.append("#" + (i+1) + " " + result + "\n");
        }
        System.out.println(sb);
    }

    public static int width(int x) {

        for(int i=1 ; i<=9 ; i++) {
            if(!arr.get(x).contains(i)) return 0;
        }

        return 1;
    }

    public static int length(int y) {
        boolean[] visited = new boolean[10];

        for(int i=0 ; i<9 ; i++) {
            int idx = arr.get(i).get(y);

            if(!visited[idx]) {
                visited[idx] = true;
            } else {
                return 0;
            }
        }

        return 1;
    }

    public static int square(int x, int y) {
        boolean[] visited = new boolean[10];

        for(int i=x ; i<3 ; i++) {
            for(int j=y ; j<3 ; j++) {
                int idx = arr.get(i).get(j);
                if(!visited[idx]) visited[idx] = true;
                else return 0;
            }
        }

        return 1;
    }
}
