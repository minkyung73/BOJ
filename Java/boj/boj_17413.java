package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_17413 {
    public static void main(String[] args) {
        // 단어 뒤집기 2

        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        // 태그가 있는 경우
        if(S.contains("<") && S.contains(">")) {
            List<Integer> start = new ArrayList<>();
            List<Integer> end = new ArrayList<>();

            // < 인덱스 저장
            int findIndex = S.indexOf("<");
            while(findIndex>=0) {
                start.add(findIndex);
                findIndex = S.indexOf("<", findIndex+1);
            }

            // > 인덱스 저장
            int findIndex2 = S.indexOf(">");
            while(findIndex2>=0) {
                end.add(findIndex2);
                findIndex2 = S.indexOf(">", findIndex2+1);
            }

            // 단어 저장
            List<String> str = new ArrayList<>();

            // 태그가 시작 전 맨 앞에 단어가 있는 경우
            if(start.get(0) != 0){
                String subString = S.substring(0, start.get(0));
                if(subString.contains(" ")) {
                    String[] s = subString.split(" ");
                    for(String s1 : s) str.add(s1);
                } else {
                    str.add(subString);
                }
            }

            for (int i=0 ; i<start.size() ; i++) {
                // 태그 저장
                str.add(S.substring(start.get(i), end.get(i)+1));

                // 단어 저장 (2개 이상의 단어일 경우 split)
                if(i < start.size()-1){
                    if(end.get(i)+1==start.get(i+1)) continue;
                    String subString = S.substring(end.get(i) + 1, start.get(i + 1));

                    if(subString.contains(" ")) {
                        String[] s = subString.split(" ");
                        for (String s1 : s) str.add(s1);
                    } else {
                        str.add(subString);
                    }
                }
            }

            // 태그가 끝난 후 맨 뒤에 단어가 있는 경우
            if(end.get(end.size()-1) + 1 <= S.length()-1){
                String subString = S.substring(end.get(end.size()-1)+1, S.length());
                if(subString.contains(" ")) {
                    String[] s = subString.split(" ");
                    for(String s1 : s) str.add(s1);
                } else {
                    str.add(subString);
                }
            }

            int flag = 1;
            for(int i=0 ; i<str.size() ; i++) {
                if(str.get(i).contains("<")) {  // 태그
                    System.out.print(str.get(i));
                    flag = 1;
                } else {    // 단어
                    StringBuffer sb = new StringBuffer(str.get(i));
                    if(flag == 0) System.out.print(" ");
                    System.out.print(sb.reverse());
                    flag = 0;
                }
            }
        }
        else {    // 태그가 없는 경우
            List<String> str = List.of(S.split(" "));
            for (String s : str) {
                StringBuffer sb = new StringBuffer(s);
                System.out.print(sb.reverse() + " ");
            }
        }
    }
}
