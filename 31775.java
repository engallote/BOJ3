import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();
		int[] alp = new int[26];
		
		if((int) str1.charAt(0) >= 97) alp[str1.charAt(0) - 'a'] += 1;
		if((int) str2.charAt(0) >= 97) alp[str2.charAt(0) - 'a'] += 1;
		if((int) str3.charAt(0) >= 97) alp[str3.charAt(0) - 'a'] += 1;
		
		if(alp['l' - 'a'] > 0 && alp['k' - 'a'] > 0 && alp['p' - 'a'] > 0)
			System.out.println("GLOBAL");
		else System.out.println("PONIX");
	}
}