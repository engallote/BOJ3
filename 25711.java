import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int Q = Integer.parseInt(st.nextToken());
    	double[][] arr = new double[N + 1][2];
    	double[] right = new double[N + 1], left = new double[N + 1];
    	
    	for(int i = 0; i < 2; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= N; j++) {
    			arr[j][i] = Double.parseDouble(st.nextToken());
    			if(i == 1) {
    				if(j == 1) continue;
    				if(arr[j][i] == arr[j - 1][i]) {//평지
    					right[j] += right[j - 1] + calc(arr[j - 1][0], arr[j - 1][1], arr[j][0], arr[j][1]) * 2;
    				}
    				else if(arr[j - 1][i] < arr[j][i]) {//오르막길
    					right[j] += right[j - 1] + calc(arr[j - 1][0], arr[j - 1][1], arr[j][0], arr[j][1]) * 3;
    				}
    				else if(arr[j - 1][i] > arr[j][i]) {//내리막길
    					right[j] += right[j - 1] + calc(arr[j - 1][0], arr[j - 1][1], arr[j][0], arr[j][1]);
    				}
    			}
    		}
    	}
    	
    	for(int i = N - 1; i >= 0; i--) {
    		if(arr[i][1] == arr[i + 1][1]) {//평지
				left[i] += left[i + 1] + calc(arr[i + 1][0], arr[i + 1][1], arr[i][0], arr[i][1]) * 2;
			}
			else if(arr[i + 1][1] < arr[i][1]) {//오르막길
				left[i] += left[i + 1] + calc(arr[i + 1][0], arr[i + 1][1], arr[i][0], arr[i][1]) * 3;
			}
			else if(arr[i + 1][1] > arr[i][1]) {//내리막길
				left[i] += left[i + 1] + calc(arr[i + 1][0], arr[i + 1][1], arr[i][0], arr[i][1]);
			}
    	}
    	
    	while(--Q >= 0) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		if(x < y) bw.write((right[y] - right[x]) + "\n");
    		else bw.write((left[y] - left[x]) + "\n");
    	}
    	bw.flush();
	}

	private static double calc(double a, double b, double c, double d) {
		return Math.sqrt(Math.abs(a - c) * Math.abs(a - c) + Math.abs(b - d) * Math.abs(b - d));
	}
}