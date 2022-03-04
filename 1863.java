import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();
		int res = 0;
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int h = sc.nextInt();
			
			if(st.isEmpty() || st.peek() < h) {
				if(h == 0) continue;
				st.push(h);
				++res;
			}
			else {
				if(h == 0) {
					st.clear();
					continue;
				}
				
				//현재 h보다 높은 건물들 삭제
				while(!st.isEmpty() && st.peek() > h) st.pop();
				
				if(!st.isEmpty() && st.peek() == h) continue;//같은 높이의 건물이면 건너뛰기
				else if(!st.isEmpty() && st.peek() != h) {
					++res;
					st.push(h);
				}
				else if(st.isEmpty() && h > 0) {
					++res;
					st.push(h);
				}
			}
		}
		
		System.out.println(res);
	}
}