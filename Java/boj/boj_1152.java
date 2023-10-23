package boj;

import java.util.Scanner;

public class boj_1152 {
    public static void main(String[] args){
//        단어의 개수
        Scanner sc = new Scanner(System.in);

        String words = sc.nextLine();
        words = words.trim();

        String[] arrStr = words.split(" ");

        if(words.equals(""))
            System.out.println("0");
        else
            System.out.println(arrStr.length);
    }
}
