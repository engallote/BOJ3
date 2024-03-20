import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		
		int x = 0, y = 0;
		for(int i = 0; i < Math.min(K, 2 * N); i++) {
			for(int idx = 0; idx < N; idx++) {
				if(ch[idx] == 'U') x -= 1;
				else if(ch[idx] == 'D') x += 1;
				else if(ch[idx] == 'R') y += 1;
				else y -= 1;
				
				if(x == 0 && y == 0) {
					System.out.println("YES");
					return;
				}
			}
		}
		
		System.out.println("NO");
	}
}