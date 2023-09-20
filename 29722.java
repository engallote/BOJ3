import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] date = sc.next().split("-");
		int N = sc.nextInt();
		
		int y = Integer.parseInt(date[0]), m = Integer.parseInt(date[1]), d = Integer.parseInt(date[2]);
		
		int div = N / 30, mod = N % 30;
		
		d += mod;
		if(d > 30) {
			d %= 30;
			div += 1;
		}
		
		int div2 = div / 12, mod2 = div % 12;
		
		m += mod2;
		if(m > 12) {
			m %= 12;
			div2 += 1;
		}
		
		y += div2;
		
		System.out.println(y + "-" + (m < 10? "0":"") + m + "-" + (d < 10 ? "0":"") + d);
	}
}