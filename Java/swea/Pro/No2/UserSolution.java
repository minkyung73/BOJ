package swea.Pro.No2;

import java.util.*;

class UserSolution {
    private TreeMap<Integer, TreeSet<Player>> players;
    private int N, L;

    public class CustomComparator implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            return o1.ability != o2.ability ? o2.ability - o1.ability : o1.id - o2.id;
        }
    }

    void init(int N, int L, int mAbility[]) {
        players = new TreeMap<>();
        this.N = N;
        this.L = L;

        int idx = 0;
        for (int i = 0; i < L; i++) {
            players.put(i, new TreeSet<>(new CustomComparator()));
            for (int j = 0; j < N / L; j++)
                players.get(i).add(new Player(mAbility[idx], idx++, i));
        }
    }

    int move() {
        // TODO: Queue 로 바꿀 수도 있을 듯? 뭐가 더 빠른지 보자
        List<Player> move_list = new ArrayList<>();
        int sumId = 0;

        // move_list
        // [FIg. 4] 참조
        for (int i = 0; i < L - 1; i++) {
            Player last = players.get(i).last();
            Player first = players.get(i + 1).first();

            sumId += last.id + first.id;

            move_list.add(last);
            move_list.add(first);
        }

        // index 문제!!!!!!
        for (int i = 0; i < L - 1; i++)
            swap(i, move_list.remove(0), move_list.remove(0));

        return sumId;
    }

    private void swap(int idx, Player p1, Player p2) {
        players.get(idx).remove(p1);
        players.get(idx+1).remove(p2);

        players.get(idx).add(p2);
        players.get(idx+1).add(p1);
    }

    int trade() {
        List<Player> trade_list = new ArrayList<>();
        int sumId = 0;

        // trade_list
        // [Fig. 6] 참조
        for (int i = 0; i < L-1; i++) {
            // TODO: 중간 값을 이렇게 빼는 게 맞나?
            Player mid = findMid(players.get(i));
            Player first = players.get(i + 1).first();

            sumId += mid.id + first.id;

            trade_list.add(mid);
            trade_list.add(first);
        }

        // swap
        for (int i = 0; i < L - 1; i++)
            swap(i, trade_list.remove(0), trade_list.remove(0));

        return sumId;
    }

    public Player findMid(TreeSet<Player> players) {
        Player higher = players.higher(players.first());
        Player lower = players.lower(players.last());

        while (true) {
            if(higher == null || lower == null) break;
            if(higher.equals(lower)) break;

            higher = players.higher(higher);
            lower = players.lower(lower);
        }

        return higher;
    }

    public class Player {
        int ability, id, league;

        public Player(int ability, int id, int league) {
            this.ability = ability;
            this.id = id;
            this.league = league;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "ability=" + ability +
                    ", id=" + id +
                    ", league=" + league +
                    '}';
        }

        public boolean equals(Player p) {
            return this.ability == p.ability
                    && this.id == p.id
                    && this.league == p.league;
        }
    }
}