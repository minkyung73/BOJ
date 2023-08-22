import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_11866 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> people = new ArrayList<>();
        for(int i=0 ; i<N ; i++)
            people.add(i+1);

        List<Integer> result = new ArrayList<>();
        int idx = K-1;
        while (!people.isEmpty()) {
            if(idx >= people.size())
                idx %= people.size();

            if(idx < people.size())
                result.add(people.remove(idx));

            idx += K-1;
        }

        System.out.print("<");
        for(int i=0 ; i<N ; i++){
            if(i < N-1)
                System.out.print(result.get(i) + ", ");
            else
                System.out.print(result.get(i));
        }
        System.out.println(">");
    }
}
