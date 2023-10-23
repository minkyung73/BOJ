package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10250 {
    // ACM 호텔

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        arr = new int[t][3];
        for(int i=0 ; i<t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // h
            arr[i][1] = Integer.parseInt(st.nextToken());   // w
            arr[i][2] = Integer.parseInt(st.nextToken());   // n
        }

        for(int i=0 ; i<t ; i++) {
            int floor=1, room;

            if(arr[i][2] % arr[i][0] == 0) room = arr[i][2] / arr[i][0];
            else room = arr[i][2] / arr[i][0] + 1;

            if(arr[i][2] % arr[i][0] == 0) floor = arr[i][0];
            else floor = arr[i][2] % arr[i][0];

            System.out.println(floor*100 + room);
        }
    }
}
