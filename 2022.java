import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double c = sc.nextDouble();
		
		double l = 0.0, r = Math.min(x, y), mid = 0, res = 0;
		while(l <= r) {
			mid = (l + r) / 2.0;
			
			double a = Math.sqrt(x * x - mid * mid);
			double b = Math.sqrt(y * y - mid * mid);
			
			if((a * b) / (a + b) < c) r = mid - 0.0001;
			else {
				l = mid + 0.0001;
				res = mid;
			}
		}
		
		System.out.printf("%.3f", res);
	}
}