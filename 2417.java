import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		
		BigInteger l = BigInteger.ZERO, r = N, mid, res = new BigInteger(Long.MAX_VALUE+"");
		while(l.compareTo(r) <= 0) {
			mid = l.add(r).divide(new BigInteger("2"));
			
			if(mid.multiply(mid).compareTo(N) >= 0) {
				if(res.compareTo(mid) > 0) res = mid;
				r = mid.subtract(BigInteger.ONE);
			}
			else l = mid.add(BigInteger.ONE);
		}
		
		System.out.println(res);
	}
}