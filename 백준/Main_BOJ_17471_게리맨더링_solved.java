package BOJ_17471_게리맨더링;
// 1. 연결요소 체크에 dfs사용하였음
// 2. 구역이 2개밖에 없을 때 예외처리
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17471_게리맨더링_solved {
	static int N, population[], answer = Integer.MAX_VALUE;
	static boolean area[], adjMatrix[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		area = new boolean[N+1];
		adjMatrix = new boolean[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				int temp = Integer.parseInt(st.nextToken());
				adjMatrix[i][temp] = true;
			}
		}
		if(N==2) comb(0, 1, 1);	// 구역이 2개밖에 없으면 1개만 뽑는다.
		for(int i = 1; i < N-1; i++) {	// 최소 1개에서 최대 N-2개까지 뽑는다.
			comb(0, 1, i);
		}
		
		// 두 집단으로 나누는 것이 불가능하면 -1 출력, 아니면 answer 출력
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	static void comb(int count, int start, int limit) {
		if(count == limit) {
			// 1. area[i] 값이 true 인 구역들이 모두 연결되어 있는지 확인, 나머지 구역들이 모두 연결되어 있는지 확인
			// 2. 연결되어있으면 인구수 차이 비교
			int[] a = new int[limit];
			int[] b = new int[N-limit];
			int aCnt = 0, bCnt = 0;
			for(int i = 1; i <= N; i++) {
				if(area[i]==true) a[aCnt++] = i;
				else b[bCnt++] = i;
			}
			if(linkChk(a) == -1 || linkChk(b) == -1) return;	// 연결여부 체크
			answer = Math.min(answer, Math.abs(linkChk(a) - linkChk(b)));	// 인구수 비교
		}
		
		for(int i = start; i <= N; i++) {
			area[i] = true;
			comb(count+1, i+1, limit);
			area[i] = false;
		}
	}
	
	/** 매개변수로 받은 배열의 요소가 모두 연결되어 있는지 확인 */
	static int linkChk(int[] arr) {
		int len = arr.length;
		if(len==1) return population[arr[0]];
		
		// 연결되지 않은 요소가 있으면 -1 리턴
		visited = new boolean[N+1];
		visited[arr[0]] = true;
		dfs(arr, arr[0]);
		for(int i : arr) {
			if(!visited[i]) return -1;
		}
		
		// 모두 연결되어 있으면 인구수 합을 계산하여 리턴
		int sum = 0;
		for(int i = 0; i < len; i++) {
			sum += population[arr[i]];
		}
		return sum;
	}
	
	// dfs 사용해서 연결 여부 판단
	static boolean[] visited;
	static void dfs(int[] arr, int row) {
		for(int i : arr) {
			if(adjMatrix[row][i] == true && !visited[i]) {
				visited[i] = true;
				dfs(arr, i);
			}
		}
	}
}














