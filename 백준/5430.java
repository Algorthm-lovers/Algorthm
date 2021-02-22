package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    private void run() throws IOException{
        String input = "";
        String output = "";
        boolean isReverse = false; //true시에 순서가 바뀐것 false 시에 순서가 그대로인것
        boolean isError = false;
        int test_case = 0;
        char[] function;
        int array_length = 0;

        Deque<String> deque = new LinkedList<String>(); // deque 선언. 배열 뒤집는 경우에는 뒤에서부터 뺀다
                                                        // R이 수행된 이후에 첫번째 숫자 버리는 경우에는 맨 뒤의 문자 버린다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        test_case = Integer.parseInt(br.readLine()); // test case의 수 입력 loop에 사용됨.
        if(test_case > 101){ // 테스트 케이스의 개수는 최대 100이다.
            return;
        }
        for(int i = 0; i< test_case; i++){
            function = br.readLine().toCharArray(); // 수행될 function 입력 <char 형 배열로>
            array_length = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 갯수 n의 입력

            input = br.readLine();
            input = input.substring(1,input.length()-1);
            StringTokenizer st = new StringTokenizer(input,",");

            while(st.hasMoreTokens()){
                deque.add(st.nextToken()); // deque에 값 삽입 완료
            }

            for(int j = 0; j < function.length; j++){ // function 수행

                if(function[j] == 'R'){
                    isReverse = !isReverse;
                }
                else{
                    if(deque.isEmpty()){
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                }
                if(isReverse){
                    deque.pollLast();
                }
                else{
                    deque.pollFirst();
                }
            }
            if(!isError) {
                System.out.print("[");
                if (isReverse) {
                    while (deque.size() > 1) {
                        System.out.print(deque.pollLast() + ",");
                    }
                } else {
                    while (deque.size() > 1) {
                        System.out.print(deque.pollFirst());
                    }
                }
                if (deque.size() != 0) {
                    System.out.print(deque.getFirst());
                }
                System.out.println("]");
            }
        }

    }
}
