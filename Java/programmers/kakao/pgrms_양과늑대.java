package programmers.kakao;

public class pgrms_양과늑대 {
    class Solution {
        int[] gInfo;
        int[][] gEdges;
        int maxSheepNum;

        public int solution(int[] info, int[][] edges) {
            int answer = 0;

            gInfo = info;
            gEdges = edges;
            maxSheepNum = 0;

            DFS(0, new boolean[info.length], 0, 0);

            return maxSheepNum;
        }

        public void DFS(int idx, boolean[] visited, int sheepNum, int wolfNum) {
            visited[idx] = true;

            if(gInfo[idx] == 0) {
                sheepNum++;
                maxSheepNum = Math.max(maxSheepNum, sheepNum);
            } else wolfNum++;

            if(sheepNum <= wolfNum) return ;

            for(int[] edge : gEdges) {
                if(visited[edge[0]] && !visited[edge[1]]) {
                    visited[edge[1]] = true;
                    DFS(edge[1], visited, sheepNum, wolfNum);
                    visited[edge[1]] = false;
                }
            }
        }
    }
}
