package BOJ_10158_개미;

// 첫번째 방법 : 시간초과

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10158_개미 {
	static int w, h, p, q, t;
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
		}
		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}
}
