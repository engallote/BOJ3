import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int E = sc.nextInt();
		
		int res = E;
		
		int tmp = Math.min(A, D);
		res += tmp;
		
		A -= tmp;
		D -= tmp;
		
		tmp = Math.min(B, C);
		res += tmp;
		
		B -= tmp;
		C -= tmp;
		
		if(D > 0) res += D;
		if(C > 0) {
			while(C > 0) {
				C -= 1;
				if(A >= 2) A -= 2;
				else if(A == 1) A = 0;
				res += 1;
			}
			
			res += C;
		}
		if(B > 0) {
			tmp = B / 2;
			B %= 2;
			A -= tmp;
			
			res += tmp;
			if(B > 0) {
				if(A >= 3) {
					A -= 3;
					res += 1;
				}
				else {
					A = 0;
					res += 1;
				}
			}
		}
		
		if(A > 0) res += A / 5 + (A % 5 == 0 ? 0 : 1);
		System.out.println(res);
	}
}