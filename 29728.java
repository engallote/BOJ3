import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] chk = new boolean[N + 1];
		chk[0] = chk[1] = true;
		
		int b = 1, s = 0, w = 0;
		
		for(int i = 2; i <= N; i++) {
			if(chk[i]) {
				b += 1;
				w = 0;
				continue;
			}
			
			if(w == 1) s += 1;
			else {
				b -= 1;
				s += 2;
			}
			
			w = 1;
			
			for(int j = i + i; j <= N; j+=i) chk[j] = true;
		}
		
		System.out.println(b + " " + s);
	}
}