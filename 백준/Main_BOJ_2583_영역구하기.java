package BOJ_2583_영역구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2583_영역구하기 {
	static int M, N, K, x, y, p, q, num;
	static int[] area;
	static boolean[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		area = new int[M*N];
		map = new boolean[M][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			for(int r = M-q; r <= M-1-y; r++) {	// 맵 표현
				for(int c = x; c < p; c++) {
					map[r][c] = true;
				}
			}
		}
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c]) continue;
				dfs(r, c);
				num++;
			}
		}
		
		area = Arrays.copyOf(area, num);	// 영역의 넓이를 저장하는 배열의 크기를 영역의 수에 맞게 조절
		Arrays.sort(area);	// 영역의 넓이에 대한 오름차순으로 정렬
		
		StringBuilder sb  = new StringBuilder();	// 출력형식에 맞춰서 StringBuilder 구축
		sb.append(num).append('\n');
		for(int i = 0; i < num; i++) {
			sb.append(area[i]).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static int dr[] = {0, -1, 1, 0, 0};	// 자기자신, 상, 하, 좌, 우
	static int dc[] = {0, 0, 0, -1, 1};
	static void dfs(int r, int c) {	// 자신을 포함한 사방탐색
		for(int i = 0; i < 5; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= M || nr < 0 || nc >= N || nc < 0 || map[nr][nc]) continue;
			map[nr][nc] = true;
			area[num]++;
			dfs(nr, nc);
		}
	}
}
