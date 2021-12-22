import java.util.Set;
import java.util.HashSet;

/*
Set을 사용한 나의 풀이

궁금한점
1. HashMap과 HashSet의 속도차이가 큰가?
   - 테스트를 실행을 하고 비교결과가 큰 차이는 없었다.
   - 두 자료구조 모두 사용한 메소드의 시간복잡도는 O(1)로 같다.
   - add, contains      :   O(1)
   - put, containsKey   :   O(1)

채점 결과
정확성: 83.3
효율성: 16.7
합계: 100.0 / 100.0
*/

class Solution {

  public boolean solution(String[] phoneBook) {
    Set<String> set = new HashSet<>();
    for (String phone : phoneBook) {
      set.add(phone);
    }
    for (String phone : phoneBook) {
      for (int i = 0; i < phone.length(); i++) {
        if (set.contains(phone.substring(0, i))) {
          return false;
        }
      }
    }
    return true;
  }
}
