import java.util.*;

class Solution {

  public Object[] solution(int[] array, int[][] commands) {
    List<Integer> answerList = new ArrayList<>();

    for (int n = 0; n < commands.length; n++) {
      List<Integer> arrayList = new ArrayList<>();
      for (int i = commands[n][0] - 1; i < commands[n][1]; i++) {
        arrayList.add(array[i]);
      }
      Collections.sort(arrayList);
      answerList.add(arrayList.get(commands[n][2] - 1));
    }
    Object[] answer = answerList.toArray();

    return answer;
  }
}
