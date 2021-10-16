import java.util.Arrays;

class Solution {

  public int[] solution(int[] lottos, int[] winNums) {
    int[] answerss = new int[2];
    int count = 0;
    int zeroCount;
    for (int lotto : lottos) {
      if (lotto == 0) {
        zeroCount++;
      }
    }
    Arrays.sort(lottos);
    Arrays.sort(winNums);
    for (int winNum : winNums) {
      for (int lotto : lottos) {
        if (winNum == lotto) {
          count++;
        }
      }
    }

    answers[0] = checkRanking(zeroCount + count); //높은순위
    answers[1] = checkRanking(count); //낮은순위

    return answers;
  }

  public int checkRanking(int count) {
    if (count == 6) {
      return 1;
    } else if (count == 5) {
      return 2;
    } else if (count == 4) {
      return 3;
    } else if (count == 3) {
      return 4;
    } else if (count == 2) {
      return 5;
    } else {
      return 6;
    }
  }
}