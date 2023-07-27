import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_4949 {
    public static void main(String[] args) {
        // 균형잡힌 세상
        Scanner sc = new Scanner(System.in);

        List<String> strList = new ArrayList<>();

        // input
        while (true) {
            String str = sc.
                    nextLine();
            if(str.equals("."))
                break;
            else
                strList.add(str);
        }

        //
        for (String s : strList) {
            char[] chars = s.toCharArray();
            List<Character> parentheses = new ArrayList<>();
            int flag = 1;
            for (char c : chars) {
                if(c == '.') break;
                if (c=='(') {
                    parentheses.add(c);
                } else if (c=='[') {
                    parentheses.add(c);
                } else if (c==')') {
                    if(parentheses.isEmpty() || parentheses.get(parentheses.size()-1) != '(') {
                        flag = 0;
                        break;
                    }
                    else
                        parentheses.remove(parentheses.size()-1);
                } else if (c==']'){
                    if(parentheses.isEmpty() || parentheses.get(parentheses.size()-1) != '[') {
                        flag = 0;
                        break;
                    }
                    else
                        parentheses.remove(parentheses.size()-1);
                }
            }
            if(flag == 0 || !parentheses.isEmpty()) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
