import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class 스택_큐_기능개발 {

  public static void main(String[] args) {
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    solution(progresses, speeds);
  }

  private static int[] solution(int[] progresses, int[] speeds) {
    List<Integer> answerList = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < progresses.length; i++) {
      double remain = (100 - progresses[i]) / (double) speeds[i];
      int date = (int) Math.ceil(remain);

      if (!queue.isEmpty() && queue.peek() < date) {
        answerList.add(queue.size());
        queue.clear();
      }
      queue.offer(date);
    }
    answerList.add(queue.size());
    return answerList.stream().mapToInt(Integer::intValue).toArray();
  }
}










