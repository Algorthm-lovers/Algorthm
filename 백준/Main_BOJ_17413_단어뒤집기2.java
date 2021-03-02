package BOJ_17413_단어뒤집기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main_BOJ_17413_단어뒤집기2 {
	static String S;
	static Stack<Character> stack;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		char[] sArr = S.toCharArray();
		
		sb = new StringBuilder();	// 새로운 문자열을 저장할 sb 생성
		stack = new Stack<>();	// 문자열 뒤집기 위한 후입선출 구조의 stack 생성
		
		for(int i = 0; i < sArr.length; i++) {
			
			if (sArr[i] == '<') { // 태그 처리 : '<'를 만나면
				
				pop();	// stack에 쌓인 요소가 있으면 pop해주고,
				
				while(true) {	// '>'를 만날때까지 while 반복하며 sb에 추가
					sb.append(sArr[i]);
					i++;
					if(sArr[i] == '>') {
						sb.append(sArr[i]);	// '>'까지 sb에 추가하고 break;
						break;
					}
				}
				continue;	// 전체 for문은 continue;
			}
			
			if(sArr[i] == ' ') {	// 공백을 만나면 pop()함수 호출, 공백을 sb에 더해준 뒤 전체 for문 continue;
				pop();
				sb.append(' ');
				continue;
			}
			
			stack.push(sArr[i]);	// 공백 또는 태그 내부가 아니면 스택에 push
			
		}
		pop();	// sArr의 마지막 원소까지 체크를 마치고 루프를 빠져나오면 pop()호출하여 sb를 비워준다
		System.out.println(sb);
	}

	static void pop() {	// 스택에 쌓여있는 요소들을 후입선출로 sb에 더해준다.
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
