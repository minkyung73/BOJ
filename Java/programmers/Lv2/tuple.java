package programmers.Lv2;

import java.io.IOException;
import java.util.*;

class tuple {
    public static void main(String[] args) throws IOException {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int[] answer;

        // step 1. "},"로 split
        String[] split1 = s.split("},");

        // step 2. "{"과 "}" 제거
        for(int i=0 ; i<split1.length ; i++) {
            split1[i] = split1[i].replace("{", "");
            split1[i] = split1[i].replace("}", "");
        }

        // step 3. int 형변환
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0 ; i<split1.length ; i++) {
            String[] split2 = split1[i].split(",");

            list.add(new ArrayList<>());
            for(int j=0 ; j < split2.length ; j++) {
                list.get(i).add(Integer.parseInt(split2[j]));
            }
        }

        // step 4. 원소 개수에 따라 오름차순 정렬
        Collections.sort(list, (o1, o2) -> o1.size() < o2.size() ? -1 : 1);

        // step 5. result 구하기
        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<list.size() ; i++) {
            List<Integer> temp = list.get(i);

            for(int j=0 ; j<temp.size() ; j++) {
                if(!result.contains(temp.get(j))) {
                    result.add(temp.get(j));
                    break;
                }
            }
        }

        // step 6. result 값을 answer에 옮기기
        answer = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++)
            answer[i] = result.get(i);

        return answer;
    }
}
