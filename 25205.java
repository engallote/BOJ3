import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		
		char c = ch[N - 1];
		if(c == 'q' || c == 'w' || c == 'e' || c == 'r' || c == 't' || c == 'a' || c == 's' || c == 'd' || c == 'f' || c == 'g' || c == 'z' || c == 'x' || c == 'c' || c == 'v')
			System.out.println(1);
		else System.out.println(0);
	}
}