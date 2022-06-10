import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long sum = 0, max = -1;
		boolean flag = false;
		
		for(int i = 0; i < N; i++) {
			long num = sc.nextLong();
			sum += num;
			
			max = Math.max(max, num);
		}
		
		if(N == 1 && max == 1) flag = true;
		if(max <= sum / 2) flag = true;
		
		System.out.println(flag ? "Happy" : "Unhappy");
	}
}