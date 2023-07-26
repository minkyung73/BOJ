import java.util.*;
import java.util.stream.Collectors;

public class boj_10610 {
    public static void main(String[] args) {
        // 30

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int strLen = str.length();
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for(int i=0 ; i<strLen ; i++) {
            int temp = Integer.parseInt(str.substring(i, i+1));
            list.add(temp);
            sum += temp;
        }

        if(!str.contains("0") || sum%3 != 0){
            System.out.println(-1);
            return;
        }

        list = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for (Integer l : list) {
            System.out.print(l);
        }
    }
}
