import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		int num = 0;
		
		for(char c : ch)
			if(c != 'C') num += 1;
		
		if(num == 0) System.out.println(N);
		else {
			System.out.println(N / (num + 1));
		}
	}
}