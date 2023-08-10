import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int g = gcd(a, b);
			System.out.println(g);
		}
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		if(b > a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}