// 처음 내가 푼 문제풀이
import java.util.ArrayList;
import java.util.List;

class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    List<Integer> arrList = new ArrayList<Integer>();
    for(int i = 0; i<scoville.length; i++){
      if(scoville[i] < K ){
        arrList.add(scoville[i]);
      }
    }
    int arrListSize = arrList.size();
    if(arrListSize  % 2 == 0){
      answer = arrListSize / 2 ;
    }else if(arrListSize  % 2 != 0){
      answer = (arrListSize / 2) + 1 ;
    }
    return answer;
  }
}
/*
* 위 코드 문제점
* 1. 효율성 0
* 2. scoville.length < 2 경우 처리과정 없음
* 3. 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2) 활용 안함
* 4. 희한하게 품
*
* PriorityQueue<> 사용하여 푼 문제 풀이 발견
*/


import java.util.*;
import java.util.PriorityQueue;
class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<Integer> ();
    for(int i = 0; i<scoville.length; i++){
      heap.offer(scoville[i]);
    }
    while(heap.peek() < K){
      if(heap.length < 2) return -1;
      int value1 = heap.poll();
      int value2 = heap.poll();

      int newFood = value1 + (value2 * 2);
      heap.offer(newFood);
      answer++;
    }
    return answer;
  }
}

//풀이 출처  : https://velog.io/@peppermint100/Algo%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8D%94-%EB%A7%B5%EA%B2%8C-in-Java














