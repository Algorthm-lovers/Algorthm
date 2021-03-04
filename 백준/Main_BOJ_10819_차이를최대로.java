package BOJ_10819_차이를최대로;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10819_차이를최대로2 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = -100;	// 쓰지 않는 0번째 index에 최소값부여 (input의 최소값이 -100이므로 -100으로 초기화해도 됨)
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int half = N/2 + N%2;
		int cur = half, start = 1, end = N, sum = 0;
		while(true) {
			sum += Math.abs(arr[cur] - arr[end]); 
			cur = end--;
			if(start == half) break;
			sum += Math.abs(arr[cur] - arr[start]);
			cur = start++;
			if(end == half) break;
		}
		if(N%2==1) {	// N이 홀수개일때는 중앙에서 왼쪽으로 시작하는 경우도 계산해서, 더 큰쪽을 반환하도록 해야함
			cur = half; start = 1; end = N; int sum2 = 0;
			while(true) {
				sum2 += Math.abs(arr[cur] - arr[start]);
				cur = start++;
				if(end == half) break;
				sum2 += Math.abs(arr[cur] - arr[end]); 
				cur = end--;
				if(start == half) break;
			}
			sum = Math.max(sum, sum2);
		}
		System.out.println(sum);
	}
}
