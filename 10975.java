import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		ArrayList<Integer> aly = new ArrayList<>();
		Deque<Integer>[] dq = new LinkedList[N];
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			aly.add(num);
			dq[i] = new LinkedList<>();
		}
		
		Collections.sort(aly);
		
		int idx = 0;
		boolean flag = true;
		for(int i = 0; i < N; i++) {
			int num = arr[i], nIdx = aly.indexOf(num);
			flag = false;
			
			for(int j = 0; j < idx; j++) {
				int f = dq[j].peekFirst(), e = dq[j].peekLast();
				
				if(aly.indexOf(f) == nIdx + 1) {
					dq[j].offerFirst(num);
					flag = true;
					break;
				}
				else if(aly.indexOf(e) == nIdx - 1) {
					dq[j].offer(num);
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				dq[idx].offer(num);
				idx += 1;
			}
		}
		
		System.out.println(idx);
	}
}