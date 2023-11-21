package programmers.Lv2;


import java.util.*;

class word_chain {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> words_list = new ArrayList<>();
        String end_w = "";
        int player = 0;
        int cnt = 0;
        boolean flag = true;

        // 끝말잇기 시작
        for(int i=0 ; i<words.length ; i++) {
            player++;
            String word = words[i];

            if(i==0) {
                end_w = String.valueOf(word.charAt(word.length()-1));
                words_list.add(word);
                continue;
            }

            if(word.length() == 1 || words_list.contains(word)
                    || !(String.valueOf(word.charAt(0)).equals(end_w)) ) {
                // 탈락
                flag = false;
                cnt = i + 1;
                break;
            }
            else {
                end_w = String.valueOf(word.charAt(word.length()-1));
                words_list.add(word);
            }

            if(player > n)
                player %= n;
        }

        if(!flag) {
            answer[0] = cnt % n == 0 ? n : cnt % n;
            answer[1] = cnt % n == 0 ? cnt / n : cnt / n + 1;
        }

        return answer;
    }
}
