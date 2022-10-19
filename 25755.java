import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char d = sc.next().charAt(0);
    	int N = sc.nextInt();
    	
    	int[][] arr = new int[N][N];
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			arr[i][j] = sc.nextInt();
    	
    	if(d == 'L' || d == 'R') {
    		for(int i = 0; i < N; i++) {
    			for(int j = N - 1; j >= 0; j--) {
    				if(arr[i][j] == 1 || arr[i][j] == 8) System.out.print(arr[i][j]);
    				else if(arr[i][j] == 2) System.out.print(5);
    				else if(arr[i][j] == 5) System.out.print(2);
    				else System.out.print("?");
    				System.out.print(" ");
    			}
    			System.out.println();
    		}
    	}
    	else if(d == 'U' || d == 'D') {
    		for(int i = N - 1; i >= 0; i--) {
    			for(int j = 0; j < N; j++) {
    				if(arr[i][j] == 1 || arr[i][j] == 8) System.out.print(arr[i][j]);
    				else if(arr[i][j] == 2) System.out.print(5);
    				else if(arr[i][j] == 5) System.out.print(2);
    				else System.out.print("?");
    				System.out.print(" ");
    			}
    			System.out.println();
    		}
    	}
	}
}