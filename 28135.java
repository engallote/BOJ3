import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = 1, count = 1, twice = 1;
		while(num < N) {
			if(Integer.toString(num).contains("50")) {
				if(twice == 1) twice = 0;
				else {
					twice = 1;
					num += 1;
				}
			}
			else {
				num += 1;
				twice = 1;
			}
			
			++count;
		}
		
		System.out.println(count);
	}
}