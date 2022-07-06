import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			BigDecimal num = new BigDecimal("5");
			num = num.sqrt(MathContext.DECIMAL128);
			num = num.add(new BigDecimal("3.0"));
			num = num.pow(N);
			
			int idx = num.toString().indexOf(".");
			if(idx >= 3) {
				System.out.println("Case #" + test_case + ": " + num.toString().substring(idx - 3, idx));
			}
			else {
				System.out.print("Case #" + test_case + ": ");
				for(int i = 3 - idx; i > 0; i--) System.out.print(0);
				System.out.println(num.toString().substring(0, idx));
			}
		}
	}
}