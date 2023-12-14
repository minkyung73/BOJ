package programmers.Lv2;

import java.io.IOException;

public class skill_tree {
    public static void main(String[] args) throws IOException {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0 ; i<skill_trees.length ; i++) {
            String now_skill = skill_trees[i];
            boolean flag = true;
            int idx = 0;

            for(int j=0 ; j<now_skill.length() ; j++) {
                if(skill.contains(String.valueOf(now_skill.charAt(j)))) {
                    int temp_idx = skill.indexOf(now_skill.charAt(j));

                    if(temp_idx == idx) idx++;
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) {
                answer++;
//                System.out.println(now_skill);
            }
        }

        return answer;
    }
}
