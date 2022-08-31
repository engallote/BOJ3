import java.util.*;

public class Main {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(--N >= 0) {
			cnt = 0;
			char[] ch = sc.next().toCharArray();
			
			int res = isPalindrome(ch, 0, ch.length - 1);
			System.out.println(res + " " + cnt);
		}
	}
	private static int isPalindrome(char[] ch, int l, int r) {
		++cnt;
		if(l >= r) return 1;
		else if(ch[l] != ch[r]) return 0;
		else return isPalindrome(ch, l + 1, r - 1);
	}
}