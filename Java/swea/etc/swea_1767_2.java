package swea.etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767_2 {
    // [SW Test 샘플문제] 프로세서 연결하기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] map;
    static List<Point> coreList;
    static int maxConnectedNum;
    static int minWireLen;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            init();
            connect(0, 0, 0);
            sb.append("#").append(i).append(" ").append(minWireLen).append("\n");
        }
        System.out.println(sb);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        coreList = new ArrayList<>();
        maxConnectedNum = 0;
        minWireLen = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1 && (i!=0 && i!=N-1 && j!=0 && j!=N-1))
                    coreList.add(new Point(i, j));
            }
        }
    }

    public static void connect(int idx, int connectedNum, int wireLen) {
        // basis part
        if (idx == coreList.size()) {
            if(connectedNum > maxConnectedNum) {
                maxConnectedNum = connectedNum;
                minWireLen = wireLen;
            } else if(connectedNum == maxConnectedNum)
                minWireLen = Math.min(minWireLen, wireLen);

            return ;
        }

        // inductive part
        /**
         * 해당 방향으로 갈 수 있는지 체크
         * 갈 수 있으면 전선 깔아주기
         * 다음 인덱스로 넘어감
         * 전선 철수하기
         * 연결하지 않은 경우도
         */
        for (int i = 0; i < 4; i++) {
            if(checkDir(idx, i)) {
                int len = installWire(idx, i);
                connect(idx + 1, connectedNum + 1, wireLen + len);
                uninstallWire(idx, i);
            }
        }
        connect(idx + 1, connectedNum, wireLen);
    }

    public static boolean checkDir(int idx, int dir) {
        int x = coreList.get(idx).x;
        int y = coreList.get(idx).y;

        // 동 서 남 북
        if(dir == 0) {
            for (int i = y+1; i < N; i++) {
                if(map[x][i] != 0) return false;
            }
        } else if(dir == 1) {
            for (int i = y-1; i >= 0 ; i--) {
                if(map[x][i] != 0) return false;
            }
        } else if(dir == 2) {
            for (int i = x+1; i < N; i++) {
                if(map[i][y] != 0) return false;
            }
        } else if(dir == 3){
            for (int i = x-1; i >= 0; i--) {
                if(map[i][y] != 0) return false;
            }
        }

        return true;
    }

    public static int installWire(int idx, int dir) {
        int x = coreList.get(idx).x;
        int y = coreList.get(idx).y;

        int len = 0;

        // 동 서 남 북
        if(dir == 0) {
            for (int i = y+1; i < N; i++) {
                map[x][i] = 2;
                len++;
            }
        } else if(dir == 1) {
            for (int i = y-1; i >= 0 ; i--) {
                map[x][i] = 2;
                len++;
            }
        } else if(dir == 2) {
            for (int i = x+1; i < N; i++) {
                map[i][y] = 2;
                len++;
            }
        } else if(dir == 3){
            for (int i = x-1; i >= 0; i--) {
                map[i][y] = 2;
                len++;
            }
        }

        return len;
    }

    public static void uninstallWire(int idx, int dir) {
        int x = coreList.get(idx).x;
        int y = coreList.get(idx).y;

        // 동 서 남 북
        if(dir == 0) {
            for (int i = y+1; i < N; i++) map[x][i] = 0;
        } else if(dir == 1) {
            for (int i = y-1; i >= 0 ; i--) map[x][i] = 0;
        } else if(dir == 2) {
            for (int i = x+1; i < N; i++) map[i][y] = 0;
        } else if(dir == 3){
            for (int i = x-1; i >= 0; i--) map[i][y] = 0;
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("===========================");
    }
}