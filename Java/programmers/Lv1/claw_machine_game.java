package programmers.Lv1;

import java.util.*;

class claw_machine_game {
    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int board_size = board.length;
        List<Integer> basket = new ArrayList<>();

        for(int i=0 ; i<moves.length ; i++) {
            int move = moves[i]-1;
            int doll = 0;

            // 인형 뽑기
            for(int j=0 ; j < board_size ; j++) {
                if(board[j][move] != 0) {
                    doll = board[j][move];
                    board[j][move] = 0;
                    break;
                }
            }

            if(doll!=0) basket.add(doll);

            // 같은 인형 터뜨리기
            boolean flag = true;
            while (basket.size() >= 2 && flag) {
                int size = basket.size();
                if(basket.get(size-1).equals(basket.get(size-2))) {
                    basket.remove(size-1);
                    basket.remove(size-2);
                    answer += 2;
                    continue;
                }

                flag = false;
            }
        }

        return answer;
    }
}
