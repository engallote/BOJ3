import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int t = 0, sum = 0;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			sum += num;
			
			t += num / 2;
		}
		
		if(sum % 3 != 0) {
			System.out.println("NO");
			return;
		}
		
		if(t >= sum / 3) System.out.println("YES");
		else System.out.println("NO");
	}
}