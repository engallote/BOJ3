import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			double cm = sc.nextDouble();
			double kg = sc.nextDouble();
			double bmi = kg / ((cm / 100) * (cm / 100));
			if(cm < 140.1) System.out.println(6);
			else if(cm < 146) System.out.println(5);
			else if(cm < 159) System.out.println(4);
			else if(cm < 161) {
				if(bmi < 16 || bmi >= 35) System.out.println(4);
				else System.out.println(3);
			}
			else if(cm < 204) {
				if(bmi < 16 || bmi >= 35) System.out.println(4);
				else if((16 <= bmi && bmi < 18.5) || (30 <= bmi && bmi < 35)) System.out.println(3);
				else if((18.5 <= bmi && bmi < 20) || (25 <= bmi && bmi < 30)) System.out.println(2);
				else if(20 <= bmi && bmi < 25) System.out.println(1);
			}
			else System.out.println(4);
		}
	}
}