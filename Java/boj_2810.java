import java.util.Scanner;

public class boj_2810 { // 컵홀더
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int seat_num = sc.nextInt();    // 좌석 수
        String seat = sc.next();        // 좌석 정보

        int cup_holder_num = 2; // 기본적으로 양 끝 2개

        char[] chars = seat.toCharArray();

        for(int i=0 ; i<seat_num-1 ; i++) {
            if(chars[i] == 'S') {
                cup_holder_num++;
            } else if (chars[i] == 'L') {
                i++;
                if(i != seat_num-1)
                cup_holder_num++;
            }
        }

        if(seat_num < cup_holder_num)
            System.out.println(seat_num);
        else
            System.out.println(cup_holder_num);
    }
}