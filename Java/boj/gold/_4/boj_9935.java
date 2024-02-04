package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        while(true) {
            if(str.contains(bomb)) {
                str = str.substring(0, str.indexOf(bomb))
                        + str.substring(str.indexOf(bomb) + bomb.length());
            } else break;
        }

        // output
        System.out.println(str.length() == 0 ? "FRULA" : str);
    }
}
