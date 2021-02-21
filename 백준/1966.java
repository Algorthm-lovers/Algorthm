package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


public class Main {

    public static class Docs{
        public int order;
        public int importance;
        public Docs(int order, int importance){
            this.order = order;
            this.importance = importance;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine()); // (1) 테스트 케이스의 수 입력

        String[] test_case2 = new String[2]; // (2)를 입력받기 위한 String 배열
        int docs_count = 0; // 문서의 갯수 (2)
        int sel_docs_order = 0; // 몇번째로 인쇄되었는지 궁금한 문서 위치 (2)
        String[] docs_importance; // (3) 각 문서의 중요도 입력받기 위한 String 배열
        LinkedList<Docs> print_queue = new LinkedList<>(); // 중요도를 저장시키기 위한 queue 선언
        Iterator<Docs> iterator = print_queue.iterator();

        for(int i = 0; i < test_case; i++){ // (1) 테스트 케이스만큼 loop 실행


            test_case2 = br.readLine().split(" "); // split() 메소드로 입력받은 string 분리, 각각 저장
            docs_count = Integer.parseInt(test_case2[0]); // (2) 입력
            sel_docs_order = Integer.parseInt(test_case2[1]); // (2) 입력

            docs_importance = br.readLine().split(" "); // (3) 입력

            for(int j = 0; j < docs_importance.length ; j++){ // 입력받은 문서의 중요도의 갯수만큼 loop
                print_queue.offer(new Docs(j,Integer.parseInt(docs_importance[j]))); //queue에 각 docs에 대한 순서,중요도 삽입
            }

            int count = 0;

            while(!print_queue.isEmpty()){
                boolean isPrintable = true;
                for(int k = 1; k < print_queue.size(); k++){
                    if(print_queue.element().importance < print_queue.get(k).importance){
                        isPrintable = false;
                        break;
                    }
                }
                if(isPrintable){
                    count++;
                    if(print_queue.element().order == sel_docs_order){
                        System.out.println(count);
                    }
                    print_queue.poll();
                }
                else{
                    Docs temp = print_queue.poll();
                    print_queue.add(temp);
                }
            }

            /* concurrent issue로 iterator를 사용한 삽입,삭제는 불가능
            for(Docs iter : print_queue){
                int count = 0; // 몇번째로 인쇄가 되는지 확인하는 count
                if(print_queue.element().importance < iter.importance){ // 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면,
                    print_queue.offer(print_queue.poll()); // 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다.
                }
                else{
                    if(iter.order == sel_docs_order){ // 현재 문서보다 중요도가 높은 문서가 하나라도 없고, 이 문서가 입력받은 순서의 문서가 맞다면
                        count++; // count를 하나 증가시키고
                        System.out.println(count); // 출력
                    }
                    else{
                        count++; // 현재 문서보다 중요도가 높은 문서가 하나도 없지만, 이 문서는 입력받은 순서의 문서는 아니다.
                    }
                }
            }
            */

            print_queue.clear(); // 혹시가 큐가 비어있지 않다면 다음 입력을 받기 위해서 사용된 print_queue를 비워준다.
        }

    }
}
