import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		
		if(Integer.toString(d).length() > N) System.out.println("No solution");
		else if(d == 1) {
			System.out.print(1);
			for(int i = 1; i < N; i++) System.out.print(0);
			System.out.println();
		}
		else {
			System.out.print(d);
			N -= Integer.toString(d).length();
			for(int i = 0; i < N; i++) System.out.print(0);
			System.out.println();
		}
	}
}