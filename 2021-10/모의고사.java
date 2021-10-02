import java.util.*;

class Solution {

  public int[] solution(int[] answers) {

    int answersLength = answers.length;
    int[] student1 = {1, 2, 3, 4, 5};
    int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int correctAnswerCount1 = getCorrectCount(answers, answersLength, student1,
        student1.length);
    int correctAnswerCount2 = getCorrectCount(answers, answersLength, student2,
        student2.length);
    int correctAnswerCount3 = getCorrectCount(answers, answersLength, student3,
        student3.length);

    return getStudents(correctAnswerCount1, correctAnswerCount2, correctAnswerCount3);
  }

  public int getCorrectCount(int[] answers, int answersLength, int[] student,
      int studentLength) {
    List<Integer> list = new ArrayList<>();
    int repeatNum = answersLength / studentLength;
    int num = answersLength % studentLength;
    int result = 0;

    for (int i = 0; i < repeatNum; i++) {
      for (int j = 0; j < studentLength; j++) {
        list.add(new Integer(student[j]));
      }
    }
    for (int i = 0; i < num; i++) {
      list.add(new Integer(student[i]));
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