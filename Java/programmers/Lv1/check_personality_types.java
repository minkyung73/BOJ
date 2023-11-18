package programmers.Lv1;

class check_personality_types {
    // score
    int score_R = 0, score_T = 0;
    int score_C = 0, score_F = 0;
    int score_J = 0, score_M = 0;
    int score_A = 0, score_N = 0;

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int iter_num = survey.length;
        for(int i=0 ; i<iter_num ; i++) {
            String choice = survey[i];
            char opt1 = choice.charAt(0);
            char opt2 = choice.charAt(1);

            score(opt1, opt2, choices[i]);
        }

        // output
        answer += score_R >= score_T ? "R" : "T";
        answer += score_C >= score_F ? "C" : "F";
        answer += score_J >= score_M ? "J" : "M";
        answer += score_A >= score_N ? "A" : "N";

        return answer;
    }

    public void score(char opt1, char opt2, int choice) {
        int num = 0;

        if(choice < 4) {    // opt1에 점수
            num = 4 - choice;
            check(opt1, num);
        }
        else if(choice > 4) {   // opt2에 점수
            num = choice - 4;
            check(opt2, num);
        }
    }

    public void check(char c, int num) {
        String str = String.valueOf(c);

        if(c == 'R')
            score_R += num;
        else if(c == 'T')
            score_T += num;
        else if(c == 'C')
            score_C += num;
        else if(c == 'F')
            score_F += num;
        else if(c == 'J')
            score_J += num;
        else if(c == 'M')
            score_M += num;
        else if(c == 'A')
            score_A += num;
        else if(c == 'N')
            score_N += num;
    }
}
