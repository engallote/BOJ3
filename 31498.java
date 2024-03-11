import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		long D = sc.nextLong();
		long K = sc.nextLong();
		
		if(K == 0) {
			if((A + C) / D > (A / B + (A % B == 0 ? 0 : 1))) {
				System.out.println(A / B + (A % B == 0 ? 0 : 1));
				return;
			}
		}
		
		long l = 0, r = B / (K == 0 ? 1 : K), mid, res = Long.MAX_VALUE;
		boolean flag = false;
		while(l <= r) {
			mid = (l + r) / 2;
			
			long toka = A, doldol = A + C, tb = B;
			flag = false;
			
//			System.out.println(mid);
//			System.out.println("Dol : " + doldol + ", Toka : " + toka);
//			System.out.println("START");
			for(long i = 0; i < mid; i++) {
				
				if(tb > 0) {
					toka -= tb;
					tb -= K;	
				}
				if(toka < 0) toka = 0;
				
				doldol -= D;
				if(doldol < 0) doldol = 0;
				
//				System.out.println("Dol : " + doldol + ", Toka : " + toka);
				if(doldol <= toka) {//돌돌이와 토카가 같은 위치에 있거나 돌돌이가 앞질렀을 때
					break;
				}
				else if(toka == 0) {//토카가 집에 먼저 도착
					flag = true;
					break;
				}
			}
			
			if(flag) {
				res = Math.min(res, mid);
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		System.out.println(res == Long.MAX_VALUE ? -1 : res);
	}
}