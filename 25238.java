import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
				
		double res = (double) a * (b / 100.0);
		
		if(a < 100 || a - res < 100) System.out.println(1);
		else System.out.println(0);
	}
}