import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	char[][] arr = new char[N][M];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.next().toCharArray();
    	
    	int res = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++)
    			if(arr[i][j] == 'I' || arr[i][j] == 'E') {
    				if(i - 3 >= 0) {
    					if(sec(arr[i - 1][j]) && thr(arr[i - 2][j]) && fou(arr[i - 3][j])) ++res;
    				}
    				if(j + 3 < M) {
    					if(sec(arr[i][j + 1]) && thr(arr[i][j + 2]) && fou(arr[i][j + 3])) ++res;
    					if(i + 3 < N) {
    						if(sec(arr[i + 1][j + 1]) && thr(arr[i + 2][j + 2]) && fou(arr[i + 3][j + 3])) ++res;
    					}
    					if(i - 3 >= 0) {
    						if(sec(arr[i - 1][j + 1]) && thr(arr[i - 2][j + 2]) && fou(arr[i - 3][j + 3])) ++res;
    					}
    				}
    				if(i + 3 < N) {
    					if(sec(arr[i + 1][j]) && thr(arr[i + 2][j]) && fou(arr[i + 3][j])) ++res;
    				}
    				if(j - 3 >= 0) {
    					if(sec(arr[i][j - 1]) && thr(arr[i][j - 2]) && fou(arr[i][j - 3])) ++res;
    					if(i + 3 < N) {
    						if(sec(arr[i + 1][j - 1]) && thr(arr[i + 2][j - 2]) && fou(arr[i + 3][j - 3])) ++res;
    					}
    					if(i - 3 >= 0) {
    						if(sec(arr[i - 1][j - 1]) && thr(arr[i - 2][j - 2]) && fou(arr[i - 3][j - 3])) ++res;
    					}
    				}
    			}
    	}
    	
    	System.out.println(res);
	}

	private static boolean fou(char c) {
		if(c == 'J' || c == 'P') return true;
		return false;
	}

	private static boolean thr(char c) {
		if(c == 'F' || c == 'T') return true;
		return false;
	}

	private static boolean sec(char c) {
		if(c == 'N' || c == 'S') return true;
		return false;
	}
}