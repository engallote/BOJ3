import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1, r = 0, c = 0;
		for(int i = 1; i <= 9; i++)
			for(int j = 1; j <= 9; j++) {
				int num = sc.nextInt();
				if(max < num) {
					max = num;
					r = i;
					c = j;
				}
			}
		
		System.out.println(max);
		System.out.println(r + " " + c);
	}
}