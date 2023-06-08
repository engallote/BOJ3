import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		if(s.contains("M") && s.contains("O") && s.contains("B") && s.contains("I") && s.contains("S"))
			System.out.println("YES");
		else System.out.println("NO");
	}
}