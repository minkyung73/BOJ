package programmers.Lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 추억 점수
class memory_score {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        List<String> name_list = new ArrayList<>(Arrays.asList(name));

        for(int i=0 ; i<photo.length ; i++) {
            for(int j=0 ; j<photo[i].length ; j++) {
                int idx;

                if(name_list.contains(photo[i][j])) {
                    idx = name_list.indexOf(photo[i][j]);
                    answer[i] += yearning[idx];
                }
            }
        }

        return answer;
    }
}
