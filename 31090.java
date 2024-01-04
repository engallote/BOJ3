import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			int m1 = N % 100;
			
			if(m1 <= 1 || (N + 1) % m1 == 0) System.out.println("Good");
			else System.out.println("Bye");
		}
	}
}