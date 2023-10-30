import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1) {
			System.out.println("YES");
			System.out.println(1);
			return;
		}
		else if(N == 2) {
			System.out.println("NO");
			return;
		}
		
		boolean[] chk = new boolean[N + 1];
		chk[1] = true;
		for(int i = 2; i <= N; i++) {
			if(chk[i]) continue;
			for(int j = i + i; j <= N; j+=i) chk[j] = true;
		}
		
		System.out.println("YES");
		System.out.print("1 3 2 ");
		
		for(int i = 4; i <= N; i++) System.out.print(i + " ");
	}
}