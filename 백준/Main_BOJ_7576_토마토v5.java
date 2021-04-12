package BOJ_7576_토마토;
// bfs 사용
// 시간초과 해결방법 (최적화 전략)
// 1. 새로 익은 토마토에 대해서만 사방탐색 수행 (새로 익은 토마토는 큐를 이용하여 관리)
// 2. 큐를 사용하여 새로 익은 토마토에 대해서만 사방탐색을 수행하므로 루프를 돌 때 마다 farmCopy와 farm을 동기화시킬 필요가 없음
// 3. farmCopy를 사용할 필요가 없음
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토v5 {
	static int M, N;
	static int[][] farm;
	static boolean[][] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		farm = new int[N][M];
		isVisited = new boolean[N][M];
		queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
				if(farm[i][j]==0) cnt++;
				if(farm[i][j]==1) queue.offer(new int[] {i, j});
				
			}
		}
		
		// true가 return되면 day값을, false가 return되면 -1을 찍어주도록 한다
		System.out.println(bfs()?day:-1);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int day;
	static int cnt;
	static Queue<int[]> queue;
	
	static boolean bfs() {			
		if(cnt==0) return true;	// 모든 토마토가 익었으면 true 반환
		
		if(day!=0 && queue.isEmpty()) return false; // 이전 단계에서 새로 익은 토마토가 없고, 모든 토마토가 익은 것이 아니라면 false 반환
		
		
		int size = queue.size();
		for(int k = 0; k < size; k++){
			int r = queue.peek()[0];
			int c = queue.poll()[1];
			if(farm[r][c] == 1 && !isVisited[r][c]) { // 해당 위치의 토마토가 익었고, 주변 토마토를 익힌 적이 없으면 사방 토마토도 익힌다
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr >= N || nr < 0 || nc >= M || nc < 0 || farm[nr][nc]!=0) continue;	// 같은 부분 중복체크 발생하는 것을 확인하고 farmCopy 조건 추가해주었다
					farm[nr][nc] = 1;
					queue.offer(new int[]{nr, nc}); // 새로 익은 토마토를 큐에 저장
					cnt--;
				}
				isVisited[r][c] = true;	// 이미 한 번 주변 토마토를 익혔으면 표시해둔다
			}
		}
		day++;
		
		return bfs();
	}
}
