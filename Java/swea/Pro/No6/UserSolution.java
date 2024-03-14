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
		// 삭제할 부서
		Dept dept = depts.get(mId);
		depts.remove(mId);
		
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
		
		System.out.println(dept.num);
		return (int) dept.num;
	}

	public int distribute(int K) {
		
		
		
		
		
		
		
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