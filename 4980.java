import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] chk = new boolean[1000001];
		chk[0] = chk[1] = true;
		for(int i = 2; i <= 1000000; i++) {
			if(chk[i]) continue;
			for(int j = i + i; j <= 1000000; j+=i) chk[j] = true;
		}
		
		while(true) {
			int a = sc.nextInt();
			int d = sc.nextInt();
			int N = sc.nextInt();
			
			if(a == 0 && d == 0 && N == 0) break;
			
			int cnt = 0, num = 0;
			
			if(!chk[a]) {
				cnt = 1;
				num = a;
			}
			for(int i = 1; cnt < N; i++) {
				a += d;
				
				if(!chk[a]) {
					cnt += 1;
					num = a;
				}
			}
			
			System.out.println(num);
		}
	}
}