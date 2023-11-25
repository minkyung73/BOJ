package test.kakao;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    private static List<int[]> list = new ArrayList<>();
    private static List<Integer> sumA = new ArrayList<>();
    private static List<Integer> sumB = new ArrayList<>();
    private static List<int[]> A_combList = new ArrayList<>();
    private static List<int[]> B_combList = new ArrayList<>();
    private static int tempA = 0, tempB = 0;
    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 3, 4, 5, 6};
//        int[] arr2 = {3, 3, 3, 3, 4, 4};
//        int r = 2;
//        repeat_comb(arr1, new int[r], 0, 0, r, 'A');
//        repeat_comb(arr2, new int[r], 0, 0, r, 'B');
//        System.out.println(sumA);
//        System.out.println();
//        System.out.println(sumB);

        int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};

        int[] arr1 = {0, 1};
        int[] arr2 = {2, 3};
        int r = 2;

        int max = 0, win = 0;
        int[] result = new int[3];

        int[] dice_comb = {0, 1, 2, 3, 4, 5};
        r = 2;

        repeat_comb(arr1, new int[r], 0, 0, r, 'A', dice);
        repeat_comb(arr2, new int[r], 0, 0, r, 'B', dice);

        System.out.println(A_combList.size());

        for(int i=0 ; i<A_combList.size() ; i++) {
            int sum1 = 0, sum2 = 0;
            for(int j=0 ; j<r ; j++) {
                sum1 += dice[j][A_combList.get(i)[j]];
                sum2 += dice[j][B_combList.get(i)[j]];
            }

            System.out.println(sum1 + " " + sum2);

            if(sum1 > sum2 && sum1 > max) {
                max = sum1;
            }
        }
//            System.out.println(max);

//        for(int i=0 ; i<result.length ; i++)
//            System.out.println(result[i]);

    }

    public static void repeat_comb(int[] arr, int[] out, int start, int depth, int r, char player, int[][] dice){
        if(depth == r){
            if(player == 'A') {
                int[] comb = new int[r];
                for(int i=0 ; i<out.length ; i++) {
                    comb[i] = out[i];
//                    System.out.print(out[i]);
                }
//                System.out.println();
                A_combList.add(comb);
                return;
            }
            else if(player == 'B') {
                int[] comb = new int[r];
                for(int i=0 ; i<out.length ; i++) {
                    comb[i] = out[i];
                }
                B_combList.add(comb);
                return;
            }

        }
        for(int i=start; i<arr.length; i++){
            out[depth] = arr[i];
            repeat_comb(arr, out, i, depth+1, r, player, dice);
        }
    }

    /*public static void repeat_comb(int[] arr, int[] out, int start, int depth, int r, char player){
        if(depth == r){
            if(player == 'A') {
                tempA = 0;
                for(int i=0 ; i<out.length ; i++)
                    tempA += out[i];

                if(!sumA.contains(tempA)) sumA.add(tempA);


            }
            else if(player == 'B') {
                tempB = 0;
                for(int i=0 ; i<out.length ; i++)
                    tempB += out[i];

                if(!sumB.contains(tempB)) sumB.add(tempB);
            }
            return;
        }

        for(int i=start; i<arr.length; i++){
            out[depth] = arr[i];
            repeat_comb(arr, out, i, depth+1, r, player);
        }
    }*/

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        list.add(new int[2]);
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
                list.get(list.size()-1)[idx] = arr[i];
                idx++;
            }
        }
        System.out.println();
    }
}
