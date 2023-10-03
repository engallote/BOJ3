import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++) {
			if(ch[i] == 'R') {
				for(int j = Math.max(0, i - K); j <= Math.min(N - 1, i + K); j++) {
					if(ch[j] == '.') ch[j] = 'L';
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++)
			if(ch[i] != '.') ++cnt;
		
		System.out.println(cnt <= M ? "Yes" : "No");
	}
}