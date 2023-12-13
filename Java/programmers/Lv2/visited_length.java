package programmers.Lv2;

import java.io.IOException;

public class visited_length {
    // 방문 길이

    public static void main(String[] args) throws IOException {
        String dirs = "UDU";
        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        boolean[][][] visited = new boolean[11][11][4];

        for(int i=0 ; i< dirs.length() ; i++) {
            char command = dirs.charAt(i);
// 반대방향 갈 수 있는지
            // 갈 수 있다면 방문한 적 있으면 continue
            // 갈 수 없다면 검증할 필요 X

            // 다음 좌표
            if(command == 'U') {
                if(rangeCheck(x, y + 1)) {
                    y++;
                    if(!visited[x+5][y+5][0]) {
                        if(rangeCheck(x, y-1) && visited[x+5][y+4][1])
                            continue;
                        answer++;
                    }
                    visited[x+5][y+5][0] = true;
                }
            } else if(command == 'D') {
                if(rangeCheck(x,y - 1)) {
                    y--;
                    if(!visited[x+5][y+5][1]) {
                        if(rangeCheck(x, y+1) && visited[x+5][y+6][0])
                            continue;
                        answer++;
                    }
                    visited[x+5][y+5][1] = true;
                }
            } else if(command == 'L') {
                if(rangeCheck(x - 1, y)) {
                    x--;
                    if(!visited[x+5][y+5][2]) {
                        if(rangeCheck(x+1, y) && visited[x+6][y+5][3])
                            continue;
                        answer++;
                    }
                    visited[x+5][y+5][2] = true;
                }
            } else if(command == 'R') {
                if(rangeCheck(x + 1, y)) {
                    x++;
                    if(!visited[x+5][y+5][3]) {
                        if(rangeCheck(x-1, y) && visited[x+4][y+5][2])
                            continue;
                        answer++;
                    }
                    visited[x+5][y+5][3] = true;
                }
            }
        }

        return answer;
    }

    public static boolean rangeCheck(int x, int y) {
        return x >= -5 && x <= 5 && y >= -5 && y <= 5;
    }
}
