import java.util.*;

public class Main {
	static int res;
	static int[][] map, arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	map = new int[7][7];
    	arr = new int[7][7];
    	res = 1000000;
    	
    	for(int i = 0; i < 7; i++)
    		for(int j = 0; j < 7; j++) map[i][j] = sc.nextInt();
    	
    	int num = sc.nextInt();
    	
    	for(int i = 0; i < 7; i++)
    		solve(i, num);
    	
    	System.out.println(res);
	}
	private static void solve(int col, int num) {
		copy();
		
		int idx = 0;
		for(int i = 0; i < 7; i++) {
			if(arr[i][col] != 0) break;
			idx = i;
		}
		
		int cnt = 0;
		arr[idx][col] = num;
		boolean flag = true;
		while(flag) {
			flag = false;
			
			//row
			for(int i = 0; i < 7; i++) {
				int l = 0, r = 0;
				while(l < 7) {
					if(arr[i][l] == 0) {
						l += 1;
						continue;
					}
					r = l + 1;
					
					while(r < 7 && arr[i][r] > 0) ++r;
					cnt = r - l;
					
					for(int j = l; j < r; j++) 
						if(arr[i][j] == cnt) {
							flag = true;
							arr[i][j] = 9;
						}
					l = r + 1;
				}
			}
			
			//col
			for(int j = 0; j < 7; j++) {
				int l = 0, r = 0;
				while(l < 7) {
					if(arr[l][j] == 0) {
						l += 1;
						continue;
					}
					r = l + 1;
					
					while(r < 7 && arr[r][j] > 0) ++r;
					cnt = r - l;
					
					for(int i = l; i < r; i++) 
						if(arr[i][j] == cnt) {
							arr[i][j] = 9;
							flag = true;
						}
					l = r + 1;
				}
			}
			
			fillZero();
			fall();
		}
		
		cnt = 0;
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 7; j++)
				if(arr[i][j] > 0) ++cnt;
		
		res = Math.min(res, cnt);
	}
	private static void fillZero() {
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 7; j++) if(arr[i][j] == 9) arr[i][j] = 0;
	}
	private static void fall() {		
		for(int i = 6; i > 0; i--)
			for(int j = 0; j < 7; j++) {
				if(arr[i][j] != 0) continue;
				int x = i - 1;
				while(x >= 0) {
					if(arr[x][j] != 0) {
						arr[i][j] = arr[x][j];
						arr[x][j] = 0;
						break;
					}
					
					x -= 1;
				}
			}
	}
	private static void copy() {
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 7; j++) arr[i][j] = map[i][j];
	}
}