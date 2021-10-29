import java.util.*;

class Solution {

  public int[] solution(int[] lottos, int[] winNums) {
    int[] answer = new int[2];
    int count = 0;
    int zeroCount = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int lotto : lottos) {
      if (lotto == 0) {
        zeroCount++;
      } else {
        map.put(lotto, count);
      }
    }

    for (int winNum : winNums) {
      if (map.get(winNum) != null) {
        map.put(winNum, count++);
      }
    }

    answer[0] = getRank(zeroCount + count);
    answer[1] = getRank(count);

    return answer;
  }

  public int getRank(int count) {
    if (7 - count == 6 || 7 - count == 7) {
      return 6;
    } else {
      return 7 - count;
    }
  }
}