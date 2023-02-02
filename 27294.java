import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	int S = sc.nextInt();
    	
    	if(T <= 11) {//아침
    		System.out.println(280);
    	}
    	else if(T <= 16) {//점심
    		if(S == 0) {//술 없이
    			System.out.println(320);
    		}
    		else {//술과 함께
    			System.out.println(280);
    		}
    	}
    	else {//저녁
    		System.out.println(280);
    	}
	}
}