import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		
		System.out.println(N / 2 + M / 2);
		
		for(int i = 2; i <= M; i+=2)
			System.out.println(1 + " " + i + " " + N + " " + i);
		
		for(int i = 2; i <= N; i+=2)
			System.out.println(i + " " + 1 + " " + i + " " + M);
	}
}