import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int mul = M * K;
		
		System.out.println(((N - mul) >= 0 ? (N - mul) : 0) + " " + ((N - mul + (M - 1)) >= 0 ? (N - mul + (M - 1)) : 0));
	}
}