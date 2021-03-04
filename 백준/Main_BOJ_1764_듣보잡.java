package BOJ_1764_듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_1764_듣보잡 {
	static int N, M;
	static LinkedList<String> a, b;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new LinkedList<>();
		b = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			a.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			String temp = br.readLine();
			if(a.contains(temp)) b.add(temp);
		}
		Collections.sort(b);
		System.out.println(b.size());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < b.size(); i++) {
			sb.append(b.get(i)).append('\n');
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
