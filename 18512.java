import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int P1 = sc.nextInt();
		int P2 = sc.nextInt();
		
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i <= 1000; i++) hs.add(P1 + i * X);
		for(int i = 0; i <= 1000; i++)
			if(hs.contains(P2 + i * Y)) {
				System.out.println(P2 + i * Y);
				return;
			}
		
		System.out.println(-1);
	}
}