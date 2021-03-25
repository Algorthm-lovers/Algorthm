package BOJ_9205_맥주마시면서걸어가기;
// bfs
// 12704KB, 116ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_9205_맥주마시면서걸어가기 {
	static int t, n;
	static boolean isVisited[];
	static int getDistance(int[] a, int[] b) {	// 두 좌표 사이의 거리 구하기
		return (Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]));
	}
	static final int happy = 0, sad = -1, keepGo = 1;
	static int curr = 0;
	static int bfs() {
		int size = q.size();	// 이전 단계에서 넘어온 만큼만 큐에서 꺼내서 알고리즘 진행
		for(int qs = 0; qs < size; qs++) {
			curr = q.poll();
			for(int i = 1; i <= n+1; i++) {
				if(isVisited[i]) continue;	// 이미 방문한 곳은 다시 방문하지 않음
				if(getDistance(arr[curr], arr[i]) <= 1000) {	// 맥주 20병을 다 마시기 전에 편의점 또는 락페스티벌 탐색
					if(i==n+1) return happy;	// 락페스티벌 도착시 happy 반환
					else {
						isVisited[i] = true;
						q.offer(i);				// 편의점 도착시 방문체크 후 큐에 넣음
					}
				}
			}
		}
		if(q.size()==0) return sad;	// 락페스티벌에 도착할 수 없을 때 sad 반환
		return keepGo;
	}
	
	static int[][] arr;
	static Queue<Integer> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n+2][2];
			q = new LinkedList<>();
			isVisited = new boolean[n+2];
			
			isVisited[0] = true;
			
			st = new StringTokenizer(br.readLine());
			
			arr[0][0] = Integer.parseInt(st.nextToken());
			arr[0][1] = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// StringTokenizer를 호출하지 않고 nextToken()을 꺼내면
			// NoSuchElementException 발생.
			st = new StringTokenizer(br.readLine());
			arr[n+1][0] = Integer.parseInt(st.nextToken());
			arr[n+1][1] = Integer.parseInt(st.nextToken());
			
			q.offer(0);	// 상근이 집에서 시작 -> 큐의 초깃값으로 상근이 집의 좌표를 넣어줌
			
			while(true) {
				int res = bfs();
				if(res==happy) {
					System.out.println("happy");	// 성공시 happy 출력
					break;
				} else if(res==sad) {
					System.out.println("sad");		// 실패시 sad 출력
					break;
				}
			}
			
			
		}
	}
}
