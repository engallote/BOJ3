import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			long N = sc.nextLong();
			if(N % 3 == 2 || N % 9 == 0) System.out.println("TAK");
			else System.out.println("NIE");
		}
	}
}