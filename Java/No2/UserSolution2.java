package No2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

class UserSolution2 {
	private TreeMap<Integer, TreeSet<Player>> playersTree;
    private TreeMap<Integer, List<PriorityQueue<Player>>> playersPQ;
    private PriorityQueue<Player> maxHeap, minHeap;
    private int N, L;

    void init(int N, int L, int mAbility[]) {
    	playersTree = new TreeMap<>();
        playersPQ = new TreeMap<>();
        
        this.N = N;
        this.L = L;
        
        int idx = 0;
        List<PriorityQueue<Player>> list = new ArrayList<>();
        for(int i=0 ; i< L ; i++) {
        	playersTree.put(i, new TreeSet<>(new CustomComparator()));
        	
        	playersPQ.put(i, list);
        	playersPQ.get(i).add(new PriorityQueue<>(new test()));
        	playersPQ.get(i).add(new PriorityQueue<>(new CustomComparator()));
        	
        	for(int j=0 ; j< N / L ; j++) {
        		
        	}
        }
    }

    int move() {
        return 0;
    }

    int trade() {
        return 0;
    }
    
    public class CustomComparator implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            return o1.ability != o2.ability ? o2.ability - o1.ability : o1.id - o2.id;
        }
    }
    
    public class test implements Comparator<Player> {
		@Override
		public int compare(Player o1, Player o2) {
			CustomComparator customComparator = new CustomComparator();
			return -customComparator.compare(o1, o2);
		}
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