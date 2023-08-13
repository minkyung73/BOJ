import java.util.Scanner;

public class boj_2839 {
    public static void main(String[] args) {
        // 설탕배달

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // init
        int min_total_num = -1;
        int num3 = 0;

        // find the min_total_num
        while(3 * num3 <= N) {
            if((N - (3 * num3)) % 5 == 0){
                int num5 = (N - (3 * num3))/5;
                int temp = num3 + num5;
                if(min_total_num == -1) min_total_num = temp;
                else min_total_num = (min_total_num < temp) ? min_total_num : temp;
            }

            num3++;
        }

        // output
        System.out.println(min_total_num);
    }
}
