import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int mod = 1000000007;
		int a = 0, b = 0, c = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 1) {
				a += 1;
				a %= mod;
			}
			else if(num == 2) {
				b *= 2;
				b %= mod;
				b += a;
				b %= mod;
			}
			else {
				c += b;
				c %= mod;
			}
		}
		
		System.out.println(c);
	}
}