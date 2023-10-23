package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7568 {
    // 덩치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] person = new int[n][2];
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for(int i=0 ; i<n-1 ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                    rank[i]++;
                }
                else if(person[i][0] > person[j][0] && person[i][1] > person[j][1]){
                    rank[j]++;
                }
            }
        }

        for(int i=0 ; i<n ; i++) System.out.print(rank[i] + " ");
    }
}
