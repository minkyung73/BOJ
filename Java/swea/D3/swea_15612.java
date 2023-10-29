package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea_15612 {
    // 체스판 위의 룩 배치
    private static int[][] chess = new int[8][8];
    private static int cnt;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ;i<T ; i++) {
            // chess input
            flag = true;
            for(int j=0 ; j<8 ; j++) {
                cnt = 0;    // 같은 행에 룩이 1개 이상 있는지 (혹은 아예 없는지) 판단
                String str = br.readLine();

                for(int k=0 ; k<8 ; k++){
                    chess[j][k] = str.charAt(k);
                    if(chess[j][k] == 'O') cnt++;
                }

                if(cnt != 1) flag = false;
            }

            // 같은 열에 룩이 1개 이상 있는지 (혹은 아예 없는지) 판단
            if(flag) {
                for(int j=0 ; j<8 ; j++) {
                    cnt = 0;
                    for(int k=0 ; k<8 ; k++) {
                        if(chess[k][j] == 'O') cnt++;
                        if(cnt > 1) {
                            flag = false;
                            break;
                        }
                    }

                    if(!flag) break;
                    else if(cnt == 0) {
                        flag = false;
                        break;
                    }
                }
            }

            if(!flag) sb.append("#" + (i+1) + " no\n");
            else sb.append("#" + (i+1) + " yes\n");
        }
        System.out.println(sb);
    }
}
