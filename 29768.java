import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		if(K == 1) {
			for(int i = 0; i < N; i++) sb.append("a");
		}
		else {
			if(K <= N) {
				int sub = N - K;
				for(int i = 0; i < sub; i++) sb.append("a");
				
				for(int i = 0; i < K; i++)
					sb.append((char)(i + 'a'));
			}
			else {
				for(int i = 0; i < N - K; i++) sb.append("a");
				for(int i = 0; i < K; i++) sb.append((char)(i + 'a'));
			}
		}
		
		System.out.println(sb.toString());
	}
}