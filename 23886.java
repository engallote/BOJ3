import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		
		if(ch[0] >= ch[1] || ch[ch.length - 2] <= ch[ch.length - 1]) {
			System.out.println("NON ALPSOO");
			return;
		}
		
		int pre = (ch[1] - '0') - (ch[0] - '0');
		for(int i = 1; i < ch.length - 1; i++) {
			if(ch[i - 1] == ch[i]) {//ÆòÅºÇÑ°¡
				System.out.println("NON ALPSOO");
				return;
			}
			
			int a = ((ch[i] - '0') - (ch[i - 1] - '0')), b = ((ch[i + 1] - '0') - (ch[i] - '0'));
			if(a * b > 0) {
				if(pre == b) continue;
				else {
					System.out.println("NON ALPSOO");
					return;
				}
			}
			else pre = b;
		}
		
		System.out.println(pre < 0 ? "ALPSOO" : "NON ALPSOO");
	}
}