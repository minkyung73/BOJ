package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3190 {
    private static int n, apple, direct, seconds = 0, len = 1;
    private static int[] snake = new int[2];
    private static String cur_dir = "RIGHT";
    private static int[][] arr;
    private static Queue<Integer> secQ = new LinkedList<>();
    private static Queue<String> dirQ = new LinkedList<>();

    private static boolean change_snake() {
        if(cur_dir.equals("RIGHT")) snake[1]++;
        else if(cur_dir.equals("LEFT")) snake[1]--;
        else if(cur_dir.equals("UP")) snake[0]--;
        else if(cur_dir.equals("DOWN")) snake[0]++;

        if(snake[0] >= n || snake[1] >= n)
            return false;

        return true;
    }

    private static void change_dir(String d) {
        if(cur_dir.equals("RIGHT")) {
            if(d.equals("L")) cur_dir = "UP";
            else if(d.equals("D")) cur_dir = "DOWN";
        }
        else if(cur_dir.equals("LEFT")) {
            if(d.equals("L")) cur_dir = "DOWN";
            else if(d.equals("D")) cur_dir = "UP";
        }
        else if(cur_dir.equals("UP")) {
            if(d.equals("L")) cur_dir = "LEFT";
            else if(d.equals("D")) cur_dir = "RIGHT";
        }
        else if(cur_dir.equals("DOWN")) {
            if(d.equals("L")) cur_dir = "RIGHT";
            else if(d.equals("D")) cur_dir = "LEFT";
        }
    }

    private static void eat_apple() {
        int row = snake[0];
        int col = snake[1];

        if(arr[row][col] == 1) {
            arr[row][col] = 0;
            len++;
        }
    }

    public static void main(String[] args) throws IOException {
        // 뱀

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        // 사과 input
        apple = Integer.parseInt(br.readLine());
        for (int i=0 ; i<apple ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 1;
        }

        // 방향 전환 input
        direct = Integer.parseInt(br.readLine());
        for(int i=0 ; i<direct ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            secQ.add(s);
            dirQ.add(d);
        }

        while (true) {
            seconds++;

            // 뱀 머리 위치 이동
            // 배열의 범위를 벗어나는 경우 종료
            if(!change_snake()) break;  // function call

            // 뱀의 몸을 만난 경우 종료

            // 사과를 먹은 경우
            eat_apple();    // function call

            // 방향이 바뀌는 경우
            if(!secQ.isEmpty() && !dirQ.isEmpty() &&
                    secQ.peek() == seconds) {

                secQ.poll();
                String d = dirQ.poll();
                change_dir(d);  // function call
            }
        }

        // output
        System.out.println(seconds);
    }
}
