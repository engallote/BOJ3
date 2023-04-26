import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			
			if(N == 0) break;
			
			ArrayList<Integer> aly = new ArrayList<>();
			int zero = 0;
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				if(num == 0) zero += 1;
				else aly.add(num);
			}
			
			Collections.sort(aly);
			
			while(--zero >= 0) aly.add(2, 0);
			
			StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
			int idx = 0;
			while(idx < N) {
				if(idx % 2 == 0) sb1.append(aly.get(idx));
				else sb2.append(aly.get(idx));
				idx += 1;
			}
			
			int res = Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
			System.out.println(res);
		}
	}
}