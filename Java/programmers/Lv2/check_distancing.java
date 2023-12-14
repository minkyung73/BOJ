package programmers.Lv2;

import java.util.Arrays;

public class check_distancing {
    // 거리두기 확인하기
    private static int[] dx1 = {-1, 0, 0, 1};
    private static int[] dy1 = {0, -1, 1, 0};

    private static int[] dx2 = {0, 1, -1, 2, -2, 1, -1, 0};
    private static int[] dy2 = {-2, -1, -1, 0, 0, 1, 1, 2};

    public static void main(String[] args) {
        String[][] places = {
                       {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                       {"PXOPX",
                        "OXOXP",
                        "OXPOX",
                        "OXXOP",
                        "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(Arrays.toString(solution(places)));
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        for(int i=0 ; i<places.length ; i++) {
            String[] place = places[i];
            boolean flag = true;

            for(int j=0 ; j<5 ; j++) {
                for(int k=0 ; k<5 ; k++) {
                    if(place[j].charAt(k) == 'P') {
                        if(!distanceCheck(place, j, k)) {
                            answer[i] = 0;
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag) break;
            }
        }

        return answer;
    }

    public static boolean distanceCheck(String[] place, int x, int y) {
//        System.out.println("현재 위치: (" + x + "," + y + ")");
//         거리가 1인 경우
        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx1[i];
            int ny = y + dy1[i];

            if(rangeCheck(nx, ny) && place[nx].charAt(ny) == 'P') {
                return false;
            }
        }

        // 거리가 2인 경우 - 사이에 파티션이 있이 없으면 안됨
        for(int i=0 ; i<8 ; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];

            if(!rangeCheck(nx, ny)) continue;
            if(place[nx].charAt(ny) != 'P') continue;

            // 파티션 여부 확인
            switch (i) {
                case 0:
                    if(place[x].charAt(y-1) != 'X') return false;
                    break;
                case 1:
                    if(place[x].charAt(y-1) != 'X' || place[x+1].charAt(y) != 'X')
                        return false;
                    break;
                case 2:
                    if(place[x].charAt(y-1) != 'X' || place[x-1].charAt(y) != 'X')
                        return false;
                    break;
                case 3:
                    if(place[x+1].charAt(y) != 'X') return false;
                    break;
                case 4:
                    if(place[x-1].charAt(y) != 'X') return false;
                    break;
                case 5:
                    if(place[x+1].charAt(y) != 'X' || place[x].charAt(y+1) != 'X')
                        return false;
                    break;
                case 6:
                    if(place[x-1].charAt(y) != 'X' || place[x].charAt(y+1) != 'X')
                        return false;
                    break;
                case 7:
                    if(place[x].charAt(y+1) != 'X') return false;
                    break;
            }
        }

        return true;
    }

    public static boolean rangeCheck(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
