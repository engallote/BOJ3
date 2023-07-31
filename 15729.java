import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] now = new int[N];
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 1) {
				if(now[i] == 0) {
					now[i] = 1;
					cnt += 1;
					
					if(i + 2 < N) {
						now[i + 1] = 1 - now[i + 1];
						now[i + 2] = 1 - now[i + 2];
					}
					else if(i + 1 < N) {
						now[i + 1] = 1 - now[i + 1];
					}
				}
			}
			else {
				if(now[i] == 1) {
					now[i] = 0;
					cnt += 1;
					
					if(i + 2 < N) {
						now[i + 1] = 1 - now[i + 1];
						now[i + 2] = 1 - now[i + 2];
					}
					else if(i + 1 < N) {
						now[i + 1] = 1 - now[i + 1];
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}