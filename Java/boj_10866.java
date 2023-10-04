import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_10866 {
    // 덱
    private static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0 ; i< n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_front")) {
                dq.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("push_back")) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop_front")) {
                if(!dq.isEmpty())
                    System.out.println(dq.pollFirst());
                else
                    System.out.println(-1);
            }
            else if(command.equals("pop_back")) {
                if(!dq.isEmpty())
                    System.out.println(dq.pollLast());
                else
                    System.out.println(-1);
            }
            else if(command.equals("size")) {
                System.out.println(dq.size());
            }
            else if(command.equals("empty")) {
                if(dq.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(command.equals("front")) {
                if(!dq.isEmpty()) System.out.println(dq.getFirst());
                else System.out.println(-1);
            }
            else if(command.equals("back")) {
                if(!dq.isEmpty()) System.out.println(dq.getLast());
                else System.out.println(-1);
            }
        }
    }
}
