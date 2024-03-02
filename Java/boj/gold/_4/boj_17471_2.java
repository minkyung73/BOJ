package boj.gold._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/**
 * powerSet 을 통해 두 선거구로 나누기 (powerSet, divideTeam)
 * 선거구 내 각 구역이 인접해있는지 확인하기 (checkAdjacent)
 * 인접해있다면 인구 수 구하기 (getPops)
 */
public class boj_17471_2 {
    // 게리맨더링
    static int n;
    static int[] pops;
    static List<List<Integer>> neighbors;
    static List<Integer> teamA, teamB;
    static boolean flag;
    static int cnt;
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        powerSet(0, new boolean[n]);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        pops = new int[n];
        for (int i = 0; i < n; i++)
            pops[i] = Integer.parseInt(st.nextToken());

        neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            neighbors.add(new ArrayList<>());
            for (int j = 0; j < num; j++)
                neighbors.get(i).add(Integer.parseInt(st.nextToken())-1);
        }

        result = Integer.MAX_VALUE;
    }

    public static void powerSet(int idx, boolean[] sel) {
        // basis part
        if (idx == n) {
            divideTeam(sel);    // function call

            if(!teamA.isEmpty() && !teamB.isEmpty()) {
                int popsA = 0, popsB = 0;

                cnt = 0;
                flag = false;
                checkAdjacent(teamA, teamA.get(0), new boolean[n]);
                if(flag) popsA = getPops(teamA);

                cnt = 0;
                flag = false;
                checkAdjacent(teamB, teamB.get(0), new boolean[n]);
                if(flag) popsB = getPops(teamB);

                if(popsA != 0 && popsB != 0) result = Math.min(result, Math.abs(popsA - popsB));
            }
            return ;
        }

        // inductive part
        sel[idx] = true;
        powerSet(idx + 1, sel);
        sel[idx] = false;
        if(idx != 0) powerSet(idx + 1, sel);
    }

    public static void divideTeam(boolean[] sel) {
        teamA = new ArrayList<>();
        teamB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(sel[i]) teamA.add(i);
            else teamB.add(i);
        }
    }

    public static void checkAdjacent(List<Integer> team, int node, boolean[] visited) {
        visited[node] = true;
        cnt++;

        if(cnt == team.size()) {
            flag = true;
            return ;
        }

        for (int i = 0; i < neighbors.get(node).size(); i++) {
            int num = neighbors.get(node).get(i);
            if(!visited[num] && team.contains(num)) checkAdjacent(team, num, visited);
        }
    }

    public static int getPops(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++)
            sum += pops[team.get(i)];
        return sum;
    }
}
