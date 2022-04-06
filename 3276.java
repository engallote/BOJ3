import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = Integer.MAX_VALUE;
		int a = 0, b = 0;
		for(int i = 1; i <= N / 2 + 1; i++) {
			int j = N / i + (N % i > 0 ? 1 : 0);
			
			if(i * j >= N && res > i + j) {
				res = i + j;
				a = i;
				b = j;
			}
		}
		
		System.out.println(a + " " + b);
	}
}