import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long M = sc.nextLong();
		long T = sc.nextLong();
		long S = sc.nextLong();
		
		long home = (N / 8 * S) + (N % 8 == 0 ? -S : 0) + N;
		long dok = T + ((M / 8 + (M % 8 == 0 ? -1 : 0)) * T) * 2 + (M / 8 * S) + (M % 8 == 0 ? -S : 0) + M; 
		
		System.out.println(home > dok ? "Dok" : "Zip");
		System.out.println(Math.min(home, dok));
	}
}