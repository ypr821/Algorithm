import java.util.HashMap;
import java.util.Map;

/*
Map을 사용한 다른사람 풀이

궁금한점
1. Map을 사용했을때 key의 value값을 쓰지 않는데 다른 자료구조를 사용하면 어떨까??
   - 전에 Set으로 풀다가 테스트 통과가 안된 코드가 남아있어서 참고하여 다시 풀어봄

채점 결과
정확성: 83.3
효율성: 16.7
합계: 100.0 / 100.0
*/

class Solution {
  public boolean solution(String[] phoneBook) {
    // init <번호, 길이>
    Map<String, Integer> map=new HashMap<>();
    for(int i=0;i<phoneBook.length;i++){
      map.put(phoneBook[i],i);
    }

    // Search
    for(String p:phoneBook){
      // 1 ~ length 까지 잘라가면서 존재여부 검색
      for(int j=1;j<p.length();j++){
        if(map.containsKey(p.substring(0,j))){
          return false;
        }
      }
    }
    return true;
  }
}
