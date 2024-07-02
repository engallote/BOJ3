import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = sc.nextInt(), y = sc.nextInt();
		
		int p = 0;
		for(int i = 0; i < N; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a <= x && b > y) p = Math.max(p, b);
		}
		
		if(p != 0) System.out.println("YES");
		else System.out.println("NO");
	}
}