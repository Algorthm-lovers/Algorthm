package BOJ_10819_차이를최대로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10819_차이를최대로 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];	// 1번째 ~ N번 index까지 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int half = N/2 + N%2;	// 중앙부터 시작 (시작은 중앙부터 오른쪽 끝으로)
		int current = half, start = 1, end = N, sum = 0;
		while(true) {	// 양끝단의 점이 중앙으로 되돌아올때까지 루프
			sum += Math.abs(arr[current] - arr[end]); // 현재위치에서 오른쪽 끝까지 거리를 더해줌
			current = end--;	// 현재 위치를 오른쪽 끝으로 바꾸고, 다음 오른쪽 끝 index를 1 줄여준다
			if(start == half) break;	// 왼쪽 끝 index가 처음 위치로 돌아왔으면 break;
			sum += Math.abs(arr[current] - arr[start]);	// 현재위치에서 왼쪽 끝까지 거리를 더해줌
			current = start++;	// 현재 위치를 왼쪽 끝으로 바꾸고, 다음 왼쪽 끝 index를 1 늘려준다
			if(end == half) break;	// 오른쪽 끝 index가 처음 위치로 되돌아왔으면 break;
		}
		System.out.println(sum);
	}
}
