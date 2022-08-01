import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		for(long i = 2; i * i <= N * 2; i++) {
			long sum = N - (i * (i + 1) / 2);
			if(sum % i == 0) System.out.println((sum / i + 1) + " " + (sum / i + i));
		}
	}
}