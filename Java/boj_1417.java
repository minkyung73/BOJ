import java.util.*;

public class boj_1417 {
    public static void main(String[] args) {
        // 국회의원 선거
        Scanner sc = new Scanner(System.in);

        // input
        int N = sc.nextInt();
        List<Integer> candidate = new ArrayList<>();
        for(int i=0 ; i<N ; i++) {
            candidate.add(sc.nextInt());
        }
        int M = candidate.stream().mapToInt(Integer::intValue).sum();

        // implementation
        int max = Collections.max(candidate);
        int dasom = candidate.get(0);
        candidate = candidate.subList(1, candidate.size());

        if (N == 1 || (dasom == max && !candidate.contains(max))) System.out.println(0);
        else if(dasom == max && candidate.contains(max)) System.out.println(1);
        else {
            int cnt = 0;

            while (dasom <= max) {
                max = Collections.max(candidate);
                int maxIdx = candidate.indexOf(max);

                cnt++;
                dasom++;
                candidate.set(maxIdx, --max);
                max = Collections.max(candidate);

            }

            System.out.println(cnt);
        }
    }
}
