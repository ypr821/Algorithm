package codingTest.hash.functionDevelopment;

import java.util.ArrayList;

public class Solution {

  public int[] solution(int[] progresses, int[] speeds) {
    int[] answer = {};
    int[] dayArray = new int[progresses.length];
    ArrayList<Integer> arrayList = new ArrayList<>();
    int cnt = 0;
    int cntTask = 0;

    for (int i = 0; i < progresses.length; i++) {
      int day = 0;
      while (progresses[i] < 100) {
        ++day;
        progresses[i] += speeds[i];
      }
      if (i == 0 || dayArray[i - 1] <= day) {
        dayArray[i] = day;
        ++cnt;
      } else if (dayArray[i - 1] > day) {
        dayArray[i] = dayArray[i - 1];
      }
    }
    answer = new int[cnt];
    for (int i = 0; i < dayArray.length; i++) {
      if (i == 0) {
        ++cntTask;
      } else if (dayArray[i] == dayArray[i - 1]) {
        ++cntTask;
      } else {
        arrayList.add(cntTask);
        cntTask = 1;
      }
    }
    arrayList.add(cntTask);
    answer = arrayList.stream().mapToInt(i -> i).toArray();
    return answer;
  }
}

