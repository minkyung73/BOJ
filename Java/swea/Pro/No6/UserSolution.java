package swea.Pro.No6;

import java.util.*;

class UserSolution {
    HashMap<Integer, Dept> group;
    TreeSet<Integer> roots;
    int dfsSum;

    public void init(int N, int mId[], int mNum[]) {
        roots = new TreeSet<>();
        group = new HashMap<>();

        for (int i = 0; i < N; i++) {
            group.put(mId[i], new Dept(mNum[i], new ArrayList<>(), 0, mId[i]));
            roots.add(mId[i]);
        }

    }

    public int add(int mId, int mNum, int mParent) {
        // 상위 부서의 하위 부서 리스트에 추가
        if(group.get(mParent).child.size() == 3) return -1;
        group.get(mParent).child.add(mId);

        // mId 부서 생성
        group.put(mId, new Dept(mNum, new ArrayList<>(), mParent, group.get(mParent).root));

        // 부서가 속한 그룹의 인원 수 세기
        return BFS(mParent);
    }

    private int BFS(int parent) {
        int sum = 0;
        Queue<Dept> queue = new LinkedList<>();
        queue.offer(group.get(parent));

        while (!queue.isEmpty()) {
            Dept node = queue.poll();
            sum += node.num;

            for (Integer child : node.child) {
                queue.offer(group.get(child));
            }
        }

        return sum;
    }

    public int remove(int mId) {
        // mId 부서가 없는 경우
        if(!group.containsKey(mId)) return -1;

        // 부서 삭제 및 그 밑에 속한 부서의 인원 수 합
        dfsSum = 0;
        DFS(mId);
        return dfsSum;
    }

    private void DFS(int mId) {
        group.get(group.get(mId).parent).child.remove(Integer.valueOf(mId));

        while (!group.get(mId).child.isEmpty())
            DFS(group.get(mId).child.get(0));

        dfsSum += group.get(mId).num;
        group.remove(mId);
    }

    public int distribute(int K) {
        int totalNum = 0;

        // 각 그룹 별 인원 수
        TreeMap<Integer, Integer> groupNum = new TreeMap<>();
        for (Integer root : roots) {
            int num = BFS(root);
            totalNum += num;
            groupNum.put(root, num);
        }

        // 1. 총 인원수가 K 이하인 경우, 각 그룹의 인원 수대로 상품권을 나누어 준다.
        // -> 각 그룹 중 가장 많은 인원
        Collection<Integer> values = groupNum.values();
        if(totalNum <= K) return Collections.max(values);

        // 2. 총 인원수가 K보다 큰 경우, 상한 개수 L을 정한다. 그룹의 인원 수가 L 이하인 경우에는 그룹의 인원 수대로 상품권을 주고,
        // 그룹의 인원 수가 L을 초과하는 경우에는 L개의 상품권을 준다.
        int minNum = Collections.min(values);
        int maxNum = Collections.max(values);

        // i는 임시 상한가
        int L = 0;
        E: for(int i=minNum ; i<=maxNum ; i++) {
            int tempSum = 0;
            for (Integer value : values) {
                if(value > i) tempSum += i;
                else tempSum += value;

                if(tempSum > K) continue E;
            }

            L = Math.max(L, i);
        }
        return L;
    }

    public class Dept {
        int num, parent, root;
        List<Integer> child; // 하위 부서 ID 리스트

        public Dept(int num, List<Integer> child, int parent, int root) {
            this.num = num;
            this.child = child;
            this.parent = parent;
            this.root = root;
        }

        @Override
        public String toString() {
            return "Dept{" +
                    "num=" + num +
                    ", parent=" + parent +
                    ", root=" + root +
                    ", child=" + child +
                    '}';
        }
    }
}
