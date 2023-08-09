import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_10828 {
    public static void main(String[] args) {
        // 스택

        // input
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        sc.nextLine();
        List<String> command = new ArrayList<>();
        for(int i=0 ; i<N ; i++) {
            command.add(sc.nextLine());
        }

        // stack & output
        List<Integer> stack = new ArrayList<>();
        for (String s : command) {
            boolean empty = stack.isEmpty();
            int size = stack.size();

            if(s.contains("push")) {
                String[] split = s.split(" ");
                stack.add(Integer.parseInt(split[1]));

            } else if(s.equals("pop")) {
                if (empty) System.out.println("-1");
                else {
                    int n = stack.remove(size-1);
                    System.out.println(n);
                }

            } else if(s.equals("top")) {
                if (empty) System.out.println("-1");
                else System.out.println(stack.get(size-1));

            } else if(s.equals("size")) {
                System.out.println(size);

            } else if(s.equals("empty")) {
                if (empty) System.out.println("1");
                else System.out.println("0");

            }
        }
    }
}
