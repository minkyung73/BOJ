package No2;

import java.util.*;


class UserSolution {
    private TreeMap<Integer, TreeSet<Player>> playersTree;
    private TreeMap<Integer, List<PriorityQueue<Player>>> playersPQ;
    private PriorityQueue<Player> maxHeap, minHeap;
    private int N, L;

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

    void init(int N, int L, int mAbility[]) {
    	playersTree = new TreeMap<>();
        maxHeap = new PriorityQueue<>(new test()); // 반대로
        minHeap = new PriorityQueue<>(new CustomComparator());
        
        this.N = N;
        this.L = L;

        int idx = 0;
        for (int i = 0; i < L; i++) {
        	playersTree.put(i, new TreeSet<>(new CustomComparator()));
            for (int j = 0; j < N / L; j++) {
            	Player temp = new Player(mAbility[idx], idx++, i);
            	
            	// TreeSet
            	playersTree.get(i).add(temp);
            	
            	// Priority Queue
            	insertPQ(temp);
            }
        }
        
        for(int i=0 ; i<L ; i++) {
        	for (Player player : playersTree.get(i)) {
				System.out.println(player);
			}
        	System.out.println();
        }
    }
    
    void insertPQ(Player player) {
    	if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
    		int compare = new CustomComparator().compare(minHeap.peek(), maxHeap.peek());
    		
    		// TODO: 크다인지 작다인지 몰라 헷갈려
    		if(compare > 0) {
				Player temp = minHeap.poll();
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(temp);
			}
		}
    }
    
    // TODO: removePQ
    void removePQ(Player player) {
    	if(minHeap.contains(player)) minHeap.remove(player);
    	else if(maxHeap.contains(player)) maxHeap.remove(player);
    }

    int move() {
        Queue<Player> move_list = new LinkedList<>();
        int sumId = 0;

        // move_list
        // [FIg. 4] 참조
        for (int i = 0; i < L - 1; i++) {
            Player last = playersTree.get(i).last();
            Player first = playersTree.get(i + 1).first();

            sumId += last.id + first.id;

            move_list.offer(last);
            move_list.offer(first);
        }

        for (int i = 0; i < L - 1; i++)
        	swapTree(i, move_list.poll(), move_list.poll());

        return sumId;
    }

    private void swapTree(int idx, Player p1, Player p2) {
    	playersTree.get(idx).remove(p1);
    	playersTree.get(idx+1).remove(p2);

    	playersTree.get(idx).add(p2);
    	playersTree.get(idx+1).add(p1);
    }
    
    private void swapPQ(int idx, Player p1, Player p2) {
    	
    }

    int trade() {
        Queue<Player> trade_list = new LinkedList<>();
        int sumId = 0;

        // trade_list
        // [Fig. 6] 참조
        for (int i = 0; i < L-1; i++) {
            // TODO: 중간 값을 이렇게 빼는 게 맞나?
            Player mid = findMid(playersTree.get(i));
            Player first = playersTree.get(i + 1).first();

            sumId += mid.id + first.id;

            trade_list.offer(mid);
            trade_list.offer(first);
        }

        // swap
        for (int i = 0; i < L - 1; i++)
        	swapTree(i, trade_list.poll(), trade_list.poll());

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