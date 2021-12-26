import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 스택_큐_프린터_다른사람풀이 {

  public static void main(String[] args) {
    int[] priorities = {2, 1, 3, 2};
    int location = 2;
    if (solution(priorities, location) == 1) {
      System.out.println("test 성공");
    } else {
      System.out.println("test 실패");
    }
  }

  public static int solution(int[] priorities, int location) {
    int answer = 0;
    int l = location;
    Queue<Integer> que = new LinkedList<Integer>();
    for (int i : priorities) {
      que.add(i);
    }

    Arrays.sort(priorities);
    int size = priorities.length - 1;

    while (!que.isEmpty()) {
      Integer i = que.poll();
      if (i == priorities[size - answer]) {
        answer++;
        l--;
        if (l < 0) {
          break;
        }
      } else {
        que.add(i);
        l--;
        if (l < 0) {
          l = que.size() - 1;
        }
      }
    }
    return answer;
  }
}
