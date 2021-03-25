package BOJ_1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1600_말이되고픈원숭이_sol {
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][][] isVisited;
	static final int row = 0, col = 1, horse = 2;
	static int[] dr = {-1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1};
	// 상하좌우, 말처럼 움직이는 경우의 수 상단에서 하단으로, 좌에서 우로 순서
	static int bfs() {
		
		int qsize = q.size();
		for(int qs = 0; qs <qsize; qs++) {
			int r = q.peek()[row];
			int c = q.peek()[col];
			int h = q.poll()[horse];
			for(int i = 0; i < 12; i++) {
				
				if(i >= 4 && h == K) {	// 말처럼 K번 뛰었으면 더이상 말처럼 뛰지 못함.
					break;
				}
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nh = h;
				if(i >= 4) nh++;	// 말처럼 뛰었으면 말처럼 뛴 횟수 증가시켜줌
				
				if(nr==H-1 && nc==W-1) return 1;	// 목표지점에 도착하면 1을 반환
				
				if(nr < 0 || nc < 0 || nr >= H || nc >= W || isVisited[nr][nc][nh] || arr[nr][nc]==1) continue;
				
				isVisited[nr][nc][nh] = true;
				
				q.offer(new int[] {nr, nc, nh});
			}
		}
		if(q.size()==0) return 2;	// 방문하지 않은 좌표로 움직일 수 있는 방법이 더이상 없을 때 2를 반환
		return 0;	// 아무런 일도 없으면 0을 반환
	}
	
	
	static int K, W, H;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());	// 말처럼 뛸 수 있는 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());	// 가로
		H = Integer.parseInt(st.nextToken());	// 세로
		arr = new int[H][W];
		isVisited = new boolean[H][W][31];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(H==1 && W==1) {
			System.out.println(0);
		} else {
			int cnt = 0;
			isVisited[0][0][0] = true;	// 시작지점 방문체크
			q.offer(new int[] {0, 0, 0}); // 0, 0에서 시작, 말처럼 뛴 횟수 : 0
			while(true) {
				cnt++;
				int ans = bfs();
				if(ans==0) {
					continue;
				} else if(ans==1) {	// 목표지점 도착
					System.out.println(cnt);
					break;
				} else if(ans==2) {	// 목표지점에 갈 수 없음
					System.out.println(-1);
					break;
				}
			}
		}
	}
}
