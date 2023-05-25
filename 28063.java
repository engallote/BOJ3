import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(N == 1) System.out.println(0);
		else if(N == 2) System.out.println(2);
		else if((x == 1 && y == 1) || (x == N && y == N) || (x == 1 && y == N) || (x == N && y == 1)) System.out.println(2);
		else if(x == 1 || y == 1 || x == N || y == N) System.out.println(3);
		else System.out.println(4);
	}
}