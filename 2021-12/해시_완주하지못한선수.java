import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Solution {

  public String solution(String[] participants, String[] completions) {
    String answer = "";
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String participant : participants) {
      /*
       * 아래 조건문은 getOrDefault 메서드로 줄일 수 있다.
       * getOrDefault(Object key, V defaultValue)
       * Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
       * 예 ) map.getOrDefault(participant, 0) : 입력한 key값에 매핑된 value가 없다면 두번째 매개변수인 defaultValue를 반환한다.
       * */
      if (map.get(participant) != null) {
        map.put(participant, map.get(participant) + 1);
      } else {
        map.put(participant, 1);
      }
    }

    for (String completion : completions) {
      map.put(completion, map.get(completion) - 1);
    }

    Set<String> keySet = map.keySet();
    for (String key : keySet) {
      if (map.get(key) > 0) {
        answer = key;
      }
    }
    return answer;
  }
}