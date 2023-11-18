package programmers.Lv1;

import java.util.*;

class claw_machine_game {
    int answer = 0;
    List<Integer> basket = new ArrayList<>();

    public int solution(int[][] board, int[] moves) {
        int size = board.length;

        for(int i=0 ; i<moves.length ; i++){
            pick(board, moves[i]-1, size);
            ppang();
        }

        return answer;
    }

    public void pick(int[][] board, int move, int size) {
        // 인형 뽑기
        int num = 0;

        for(int i=0 ; i < size ; i++) {
            if(board[i][move] != 0) {
                num = board[i][move];
                board[i][move] = 0;
                basket.add(num);
                break;
            }
        }
    }

    public void ppang() {
        if(basket.size() < 2) return ;

        // 제일 끝에 있는 인덱스
        int idx = basket.size() - 1;

        if(basket.get(idx) == basket.get(idx-1)) {
            basket.remove(idx);
            basket.remove(idx-1);
            answer += 2;
        }
    }
}
