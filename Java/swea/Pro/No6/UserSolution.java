package swea.Pro.No6;

import java.util.*;

class UserSolution {
	
	int groupNum;
	List<Integer> groupList;
	HashMap<Integer, Dept> depts;
	
	public void init(int N, int mId[], int mNum[]) {
		
		groupNum = N;
		groupList = new ArrayList<>();
		depts = new HashMap<>();
		
		for(int i=0 ; i<N ; i++) {
			groupList.add(mId[i]);
			depts.put(mId[i], new Dept(mId[i], mNum[i], 0, new ArrayList<>()));
		}

//		for (int i : depts.keySet()) {
//			System.out.println(i + " " + depts.get(i));
//		}
		
		return;
	}

	public int add(int mId, int mNum, int mParent) {
		
		Dept parentDept = depts.get(mParent);
		if(parentDept.childList.size() == 3) return -1;
		
		// hashMap depts 에 추가, 부모 리스트에 추가
		depts.put(mId, new Dept(mId, mNum, mParent, new ArrayList<>()));
		depts.get(mParent).childList.add(mId);
		
		// 상위 부서 num 값 추가
		int id = mId;
		while(true) {
			int parent = depts.get(id).parent;
			if(parent == 0) break;
			depts.get(parent).num += mNum;
			id = parent;
		}
		
		return (int) depts.get(mParent).num;
	}

	public int remove(int mId) {
//		System.out.println(mId);
//		for (Integer key : depts.keySet()) {
//			System.out.println(key + " " + depts.get(key));
//		}

		// 삭제할 부서
		Dept dept = depts.get(mId);
		if(dept == null) return -1;
		long num = dept.num;

		// 부모에서 삭제 & 인원수 계속 감소 시켜야 함
		int id = mId;
		while (true) {
			int parent = depts.get(id).parent;
			if(parent == 0) break;
			depts.get(parent).num -= num;
			id = parent;
		}

		depts.remove(mId);
		depts.get(dept.parent).childList.remove(Integer.valueOf(mId));

		// 자식 삭제하기
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0 ; i<dept.childList.size() ; i++) 
			queue.offer(dept.childList.get(i));
		
		while(!queue.isEmpty()) {
			Integer poll = queue.poll();
			dept = depts.get(poll);
			depts.remove(poll);
			
			for(int i=0 ; i<dept.childList.size() ; i++)
				queue.offer(dept.childList.get(i));
		}

//		System.out.println("=========================");
//		for (Integer key : depts.keySet()) {
//			System.out.println(key + " " + depts.get(key));
//		}

		return (int) num;
	}

	public int distribute(int K) {
		long sum = 0;
		List<Long> list = new ArrayList<>();

		System.out.println("K: " + K);

		for (int i = 0; i < groupNum; i++) {
			long num = depts.get(groupList.get(i)).num;
			sum += num;
			list.add(num);
		}
		Collections.sort(list);

		for (int i = 0; i < groupNum; i++)
			System.out.println("group " + i + " : " + list.get(i));
		System.out.println("=> sum: " + sum);
		System.out.println("=======================");

		// 상품권 수가 인원 수 합 보다 많은 경우
		if(K >= sum) return Math.toIntExact(list.get(list.size() - 1));

		// 상품권 수 보다 인원 수 합이 더 많은 경우
		int L = 0;
		int sum2 = 0;
		for (int i = 0; i < list.size(); i++) {
			sum2 += list.get(i);
		}

		return 35;
	}
	
	public class Dept {
		int id;
		long num;
		int parent;
		List<Integer> childList;
		
		public Dept(int id, long num, int parent, List<Integer> childList) {
			this.id = id;
			this.num = num;
			this.parent = parent;
			this.childList = childList;
		}

		@Override
		public String toString() {
			return "Dept [id=" + id + ", num=" + num + ", parent=" + parent + ", childList=" + childList + "]";
		}
	}
}