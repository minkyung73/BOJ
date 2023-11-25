package boj.bronze._1;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1157 {
    public static void main(String[] args){
//        단어 공부
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int[] arr = new int[26];
        Arrays.fill(arr, 0);

        // 알파벳 count
        for(char ch : str.toCharArray()){
            if(ch >= 65 && ch <= 90){
                arr[ch-65]++;
            }
            else if(ch >= 97 && ch <= 122){
                arr[ch-97]++;
            }
        }

        // 가장 많이 존재하는 알파벳의 수
        int max = 0;
        int maxi = 0;
        for(int i=0 ; i<26 ; i++){
            if(arr[i] == 0)
                continue;

            if(arr[i] > max){
                max = arr[i];
                maxi = i;
            }
        }

        // max 값이 여러 개이면 ? 출력해야 하므로
        int cnt = 0;
        for(int i : arr){
            if(i == max)
                cnt += 1;

            if(cnt > 1)
                break;
        }

        // 출력
        if(cnt > 1)
            System.out.println("?");
        else{
            System.out.println((char)(maxi+65));
        }
    }
}
