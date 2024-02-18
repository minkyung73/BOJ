package swea.Pro.No2;

import java.util.*;

class UserSolution {

    private int N, L;
    private int K;  // 한 리그에 들어갈 선수의 수
    private int frontSize, lastSize;    // 한 리그 내 상위권과 하위권 선수의 수
    private ArrayList<TreeSet<Player>> leagues;

    void init(int N, int L, int mAbility[]) {
        this.N = N;
        this.L = L;
        K = N / L;

        leagues = new ArrayList<>();
        for(int i=0 ; i< 2 * L ; i++) leagues.add(new TreeSet<>(new CustomComparator()));

        int id = 0;
        frontSize = K % 2 == 0 ? K / 2 : K / 2 + 1;
        lastSize = K - frontSize;

        for (int i = 0; i < L; i++) {
            PriorityQueue<Player> players = new PriorityQueue<>(new CustomComparator());
            for (int j = 0; j < K; j++) {
                players.offer(new Player(mAbility[id], id));
                id++;
            }

            for (int j = 0; j < frontSize ; j++)
                leagues.get(i*2).add(players.poll());

            for (int j = 0; j < lastSize ; j++)
                leagues.get(i*2+1).add(players.poll());

        }

    }

    int move() {
        int sumId = 0;

        // 상위 리그 꼴찌와 하위 리그 1등 swap
        for(int i=0 ; i<L-1 ; i++) {
            Player last = leagues.get(i * 2 + 1).pollLast();
            Player first = leagues.get((i+1) * 2).pollFirst();

            leagues.get(i*2 + 1).add(first);
            leagues.get((i+1)*2).add(last);

            sumId += last.id;
            sumId += first.id;
        }

        // 리그 내 상위권 선수와 하위권 선수 swap
        for (int i = 0; i < L; i++) {
            Player high = leagues.get(i * 2).pollLast();
            Player low = leagues.get(i * 2 + 1).pollFirst();

            CustomComparator comparator = new CustomComparator();

            if(comparator.compare(high, low) > 0) {   // swap
                leagues.get(i*2).add(low);
                leagues.get(i*2+1).add(high);
            }
            else {
                leagues.get(i*2).add(high);
                leagues.get(i*2+1).add(low);
            }
        }

        return sumId;
    }

    int trade() {
        Queue<Player> players = new LinkedList<>();
        int sumId = 0;

        // 상위 리그 중간 등수와 하위 리그 1등 swap
        for(int i=0 ; i<L-1 ; i++) {
            Player mid = leagues.get(i * 2).pollLast();
            Player first = leagues.get((i+1) * 2).pollFirst();

            players.offer(mid);
            players.offer(first);

            sumId += mid.id;
            sumId += first.id;
        }

        for (int i = 0; i < L - 1; i++) {
            leagues.get((i+1)*2).add(players.poll());
            leagues.get((i)*2).add(players.poll());
        }

        // 리그 내 상위권 선수와 하위권 선수 swap
        for (int i = 0; i < L; i++) {
            Player high = leagues.get(i * 2).pollLast();
            Player low = leagues.get(i * 2 + 1).pollFirst();

            CustomComparator comparator = new CustomComparator();

            if(comparator.compare(high, low) > 0) {   // swap
                leagues.get(i*2).add(low);
                leagues.get(i*2+1).add(high);
            }
            else {
                leagues.get(i*2).add(high);
                leagues.get(i*2+1).add(low);
            }
        }

        return sumId;
    }

    class Player {
        int ability, id;

        public Player(int ability, int id) {
            this.ability = ability;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "ability=" + ability +
                    ", id=" + id +
                    '}';
        }

//        @Override
//        public int compareTo(Player o) {
//            return this.ability != o.ability ? o.ability - this.ability : this.id - o.id;
//        }
    }

    class CustomComparator implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            return o1.ability != o2.ability ? o2.ability - o1.ability : o1.id - o2.id;
        }
    }
}
