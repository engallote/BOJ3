import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int res = 0;
			
			for(int i = 1; i <= a; i++)
				for(int j = 1; j <= b; j++)
					for(int k = 1; k <= c; k++)
						if(i % j == j % k && j % k == k % i) ++res;
			
			System.out.println(res);
		}
	}
}