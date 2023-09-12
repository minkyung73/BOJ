import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class goorm_1_koi_arranging_room {
    // KOI 2017 방 배정하기
    private static int room1;
    private static int room2;
    private static int room3;
    private static int students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        room1 = Integer.parseInt(st.nextToken());
        room2 = Integer.parseInt(st.nextToken());
        room3 = Integer.parseInt(st.nextToken());
        students = Integer.parseInt(st.nextToken());

        boolean flag = false;
        for(int i = students / room3 ; i>= 0 ; i--) {
            for(int j=(students - i * room3) / room2 ; j>=0 ; j--) {
                if ((students - i * room3 - j * room2) % room1 == 0) {
                    System.out.println(1);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        if(!flag) System.out.println(0);
    }

}
