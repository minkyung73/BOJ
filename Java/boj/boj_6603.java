package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_6603 {
    private static int cnt = 0, k=1;
    private static int[] arr;
    private static boolean[] visited;

    private static void combination(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        }

        if(depth == arr.length) return;

        visited[depth] = true;
        combination(arr, visited, depth + 1, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, r);
    }

    private static void print(int[] arr, boolean[] visited) {
        for(int i=0 ; i< arr.length ; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (k != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // input
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            visited = new boolean[k];
            for (int i=0 ; i<k ; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // function call - combination
            combination(arr, visited, 0, 6);
            System.out.println();
        }
    }
}
