import java.util.*;

public class Main {
	static boolean flag = false;
	static int N, K;
	static char[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		ch = new char[N];
		
		if(K == 0) {
			for(int i = 0; i < N - 1; i++) System.out.print("B");
			System.out.println("A");
			return;
		}
		Arrays.fill(ch, 'B');
		
		for(int a = 0, b = N; a < N; a++, b--)
			if(a * b >= K) {
				for(int k = 0; k < a - 1; k++) ch[k] = 'A';
				
				int ret = K - ((a - 1) * b);
				ch[(N - 1) - ret] = 'A';
				System.out.println(new String(ch));
				return;
			}
		
		System.out.println(-1);
	}
}