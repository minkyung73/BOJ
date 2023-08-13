import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj_1003 {
    public static void main(String[] args) {
        // 피보나치 함수

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0 ; i<N ; i++) {
            arr.add(sc.nextInt());
        }

        // init
        List<List<Integer>> fibonacci = new ArrayList<>();
        fibonacci.add(Arrays.asList(1,0));
        fibonacci.add(Arrays.asList(0,1));

        //
        for (Integer num : arr) {
            if(num < 2)
                System.out.println(fibonacci.get(num).get(0) + " " + fibonacci.get(num).get(1));
            else {
                int cur_size = fibonacci.size();
                for(int i = cur_size ; i<= num ; i++){
                    int a1 = fibonacci.get(i-1).get(0) + fibonacci.get(i-2).get(0);
                    int a2 = fibonacci.get(i-1).get(1) + fibonacci.get(i-2).get(1);
                    fibonacci.add(Arrays.asList(a1, a2));
                }
                System.out.println(fibonacci.get(num).get(0) + " " + fibonacci.get(num).get(1));
            }
        }

    }
}
