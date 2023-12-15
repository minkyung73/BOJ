package programmers.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class maximize_expression {
    // 수식 최대화
    private static long max = 0;
    private static List<Long> expressionNums = new ArrayList<>();
    private static List<Character> expressionOps = new ArrayList<>();
    private static char[] ops = {'+', '-', '*'};
    private static char[] priorities = new char[3];
    private static boolean[] visited = new boolean[3];

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        init(expression);
        DFS(0);
        return max;
    }

    public static void init(String expression) {
        int idx = 0;

        // 숫자, 연산자 구분
        for(int i=0 ; i<expression.length() ; i++) {
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                expressionOps.add(ch);
                expressionNums.add(Long.parseLong(expression.substring(idx, i)));
                idx = i+1;
            }
        }
        expressionNums.add(Long.parseLong(expression.substring(idx)));
    }

    public static void DFS(int depth) {
        if(depth == 3) {
            max = Math.max(Math.abs(calcExpression()), max);
            return;
        }

        for(int i=0 ; i<ops.length ; i++) {
            if (!visited[i]) {
                priorities[depth] = ops[i];
                visited[i] = true;
                DFS(depth+1);
                visited[i] = false; // 방문 해제
            }
        }
    }

    public static long calcExpression() {
        List<Long> tmpExpressionNums = new ArrayList<>(expressionNums);
        List<Character> tmpExpressionOps = new ArrayList<>(expressionOps);

        while (tmpExpressionOps.size() > 0) {
            int maxPriority = 0;

            for (int i = 0; i < tmpExpressionOps.size(); i++)
                maxPriority = Math.max(getPriority(tmpExpressionOps.get(i)), maxPriority);

            for (int i = 0; i < tmpExpressionOps.size(); i++) {
                if (getPriority(tmpExpressionOps.get(i)) == maxPriority) {
                    tmpExpressionNums.add(i,
                            calc(tmpExpressionNums.remove(i), tmpExpressionNums.remove(i),
                            tmpExpressionOps.remove(i)));

                    break;
                }
            }
        }

        return tmpExpressionNums.get(0);
    }

    public static long calc(long num1, long num2, char op) {
        long res;

        if(op == '+') res = num1 + num2;
        else if(op == '-') res = num1 - num2;
        else res = num1 * num2;

        return res;
    }

    public static int getPriority(char op) {
        int priority;

        if(op == priorities[0]) priority = 2;   // +
        else if(op == priorities[1]) priority = 1;  // -
        else priority = 0;  // *

        return priority;
    }
}
