import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_2309 {
    public static void main(String[] args) {
        // 일곱 난쟁이

        Scanner sc = new Scanner(System.in);

        List<Integer> fakes = new ArrayList<>();
        for(int i=0 ; i<9 ; i++)
            fakes.add(sc.nextInt());
        Collections.sort(fakes);

        int fake_height =
                fakes.stream().mapToInt(Integer::intValue).sum() - 100;

        for(int i=0 ; i<9 ; i++) {
            int cur = fakes.get(i);
            int rem = fake_height - cur;

            if(fakes.contains(rem)) {
                if(cur == rem && Collections.frequency(fakes, cur) >= 2) {
                    fakes.remove(fakes.get(i));
                    fakes.remove(fakes.indexOf(rem));
                    break;
                } else {
                    fakes.remove(fakes.get(i));
                    fakes.remove(fakes.indexOf(rem));
                    break;
                }
            }
        }

        for (Integer fake : fakes) {
            System.out.println(fake);
        }
    }
}
