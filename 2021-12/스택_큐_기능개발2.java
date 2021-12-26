import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 스택_큐_기능개발2 {

  public static void main(String[] args) {
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    solution(progresses, speeds);
  }

  private static int[] solution(int[] progresses, int[] speeds) {
    List<Integer> answerList = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = progresses.length - 1; i >= 0; i--) {
      double remain = (100 - progresses[i]) / (double) speeds[i];
      stack.push(new Integer((int) Math.ceil(remain)));
    }

    int taskCount = 1;
    int popResult1 = stack.pop();
    for (int i = 0; i < progresses.length - 1; i++) {
      int popResult2 = stack.pop();
      if (popResult1 < popResult2) {
        answerList.add(taskCount);
        popResult1 = popResult2;
        taskCount = 1;
      } else {
        taskCount++;
      }
    }
    answerList.add(taskCount);
    return answerList.stream().mapToInt(Integer::intValue).toArray();
  }
}










