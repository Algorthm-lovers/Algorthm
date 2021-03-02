package BOJ_10158_개미;

// x와 y좌표를 따로 생각
// x 방향 바꾸는 조건 오타 수정
// 시작지점이 x = 0 또는 y = 0인경우 오류 발생할 수 있지만 해당 문제의 조건은 0 < p < w, 0 < q < h 이므로 고려하지 않아도 됨
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10158_개미3 {
	static int w, h, t;
	static int x, y, dx = 1, dy = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t % (2 * w); i++) {
			if (x == w || x == 0) dx *= -1;

			x += dx;

		}
		for (int i = 0; i < t % (2 * h); i++) {
			if (y == h || y == 0) dy *= -1;

			y += dy;

		}

		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}
}
