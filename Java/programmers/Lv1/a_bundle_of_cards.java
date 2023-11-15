package programmers.Lv1;
import java.util.*;

// 카드 뭉치
class a_bundle_of_cards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        List<String> c1_list = new ArrayList<>(Arrays.asList(cards1));
        List<String> c2_list = new ArrayList<>(Arrays.asList(cards2));
        boolean flag = true;

        for(int i=0 ; i<goal.length ; i++) {
            String str = goal[i];

            if(c1_list.contains(str) && c1_list.get(0).equals(str)) {
                c1_list.remove(str);
            } else if(c2_list.contains(str) && c2_list.get(0).equals(str)) {
                c2_list.remove(str);
            }else {
                flag = false;
                break;
            }
        }

        if(flag) answer = "Yes";
        else answer = "No";

        return answer;
    }
}
