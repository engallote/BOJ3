import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int pre = -1, bat = 2, res = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(pre == num) {
				res += bat * 2;
				bat *= 2;
			}
			else {
				pre = num;
				res += 2;
				bat = 2;
			}
			
			if(res >= 100) {
				pre = -1;
				res = 0;
				bat = 2;
			}
		}
		
		System.out.println(res);
	}
}