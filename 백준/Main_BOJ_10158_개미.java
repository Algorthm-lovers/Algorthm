package BOJ_10158_개미;
// 사이클을 구해 나눠주는 방식을 써보았지만 여전히 시간초과
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10158_개미 {
	static int w, h, p, q, t, loop;
	static int x, y, dx = 1, dy = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		
		x = p; y = q;
		for(int i = 0; i < t; i++) {
			if(x==w || w==0) dx *= -1;
			if(y==h || y==0) dy *= -1;
			
			x += dx;
			y += dy;
			
			if(i!=0 && p == x && q ==y) {
				t %= i;
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}
}
