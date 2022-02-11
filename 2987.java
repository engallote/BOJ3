import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ax = sc.nextDouble();
        double ay = sc.nextDouble();
        double bx = sc.nextDouble();
        double by = sc.nextDouble();
        double cx = sc.nextDouble();
        double cy = sc.nextDouble();
        
        System.out.println(Math.abs(ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2);
        
        if(ccw(ax, ay, bx, by, cx, cy) > 0) {
        	double tx = ax, ty = ay;
        	ax = cx;
        	ay = cy;
        	cx = tx;
        	cy = ty;
        }
        
        int N = sc.nextInt();
        int res = 0;
        while(--N >= 0) {
        	double x = sc.nextDouble();
        	double y = sc.nextDouble();
        	
        	double a = ccw(x, y, bx, by, ax, ay);
            double b = ccw(x, y, ax, ay, cx, cy);
            double c = ccw(x, y, cx, cy, bx, by);
            
            if(a >= 0.0 && b >= 0.0 && c >= 0.0) ++res;
        }
        
        System.out.println(res);
    }

	private static double ccw(double ax, double ay, double bx, double by, double cx, double cy) {
		return ax * (by - cy) + bx * (cy - ay) + cx * (ay - by);
	}
}