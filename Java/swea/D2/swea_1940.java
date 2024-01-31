package swea.D2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1940 {
    // 가랏! RC카!
    private static int n, speed, distance;
    private static int command, acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            n = Integer.parseInt(br.readLine());
            speed = 0;
            distance = 0;

            for(int j=0 ; j<n ;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                command = Integer.parseInt(st.nextToken());
                if(command == 1 || command == 2)
                    acc = Integer.parseInt(st.nextToken());

                distance += RC();
            }
            sb.append("#" + (i+1) + " " + distance + "\n");
        }
        System.out.println(sb);
    }

    public static int RC() {
        if(command == 1) speed += acc;
        else if(command == 2) {
            if(speed < acc)
                return 0;
            speed -= acc;
        }

        return speed;
    }
}
