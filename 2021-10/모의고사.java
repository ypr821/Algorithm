import java.util.*;

class Solution {

  public int[] solution(int[] answers) {

    int answersLength = answers.length;
    int[] studentArray1 = {1, 2, 3, 4, 5};
    int[] studentArray2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] studentArray3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int studentCorrectCount1 = getCorrectCount(answers, answersLength, studentArray1,
        studentArray1.length);
    int studentCorrectCount2 = getCorrectCount(answers, answersLength, studentArray2,
        studentArray2.length);
    int studentCorrectCount3 = getCorrectCount(answers, answersLength, studentArray3,
        studentArray3.length);

    return getStudents(studentCorrectCount1, studentCorrectCount2, studentCorrectCount3);
  }

  public int getCorrectCount(int[] answers, int answersLength, int[] studentArray,
      int studentArrayLength) {
    List<Integer> list = new ArrayList<>();
    int repeatNum = answersLength / studentArrayLength;
    int num = answersLength % studentArrayLength;
    int result = 0;

    for (int i = 0; i < repeatNum; i++) {
      for (int j = 0; j < studentArrayLength; j++) {
        list.add(new Integer(studentArray[j]));
      }
    }
    for (int i = 0; i < num; i++) {
      list.add(new Integer(studentArray[i]));
    }

    for (int i = 0; i < answersLength; i++) {
      if (answers[i] == (list.get(i).intValue())) {
        result++;
      }
    }
    return result;
  }

  public int[] getStudents(int correctCount1, int correctCount2, int correctCount3) {

    int maxValue = Math.max(Math.max(correctCount1, correctCount2), correctCount3);
    List<Integer> resultList = new ArrayList<>();

    if (maxValue == correctCount1) {
      resultList.add(1);
    }
    if (maxValue == correctCount2) {
      resultList.add(2);
    }
    if (maxValue == correctCount3) {
      resultList.add(3);
    }

    return resultList.stream().mapToInt(Integer::intValue).toArray();
  }
}