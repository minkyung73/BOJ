package programmers.Lv2;


import java.io.IOException;
import java.util.*;

class word_chain {
    public static void main(String[] args) throws IOException {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(Arrays.toString(solution(n, words)));

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};  // 번호, 차례

        int idx = 0;
        boolean flag = true;
        List<String> duplicatedWords = new ArrayList<>();

        for(int i=0 ; i<words.length ; i++) {

            // 조건 1. 한 글자인 경우
            if(words.length == 1) {
                idx = i+1;
                break;
            }

            // 조건 2. 이전에 등장한 단어
            if(!duplicatedWords.contains(words[i])) {
                if(i==0) {
                    duplicatedWords.add(words[i]);
                    continue;
                }

                // 조건 3. 이전 단어의 마지막 글자로 시작하지 않는 경우 (첫번째 시작은 검증 X)
                // 이전 단어의 마지막 글자
                String pre_word = words[i-1];
                char last_pre_w = pre_word.charAt(pre_word.length()-1);

                if(words[i].charAt(0) == last_pre_w) {
                    duplicatedWords.add(words[i]);
                }
                else {
                    idx = i+1;
                    flag = false;
                    break;  // 조건 3
                }
            }
            else {
                idx = i+1;
                flag = false;
                break;  // 조건 2
            }
        }

        answer[0] = idx % n == 0 && !flag ? n : idx % n;
        answer[1] = idx % n ==0 ? idx / n : idx / n + 1;

        return answer;
    }
}
