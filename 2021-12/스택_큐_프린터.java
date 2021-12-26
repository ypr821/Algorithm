import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 스택_큐_프린터 {

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
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> resultList = new ArrayList<>();
    /*
     * resultList
     * index 는 실제 인쇄 처리 순서
     * value 는 처음 locations
     */
    for (int i = 0; i < priorities.length; i++) {
      queue.add(i);
    }
    while (!queue.isEmpty()) {
      Integer indexOfPriorities = queue.poll();
      if (priorities[indexOfPriorities] == Arrays.stream(priorities).max().getAsInt()) {
        resultList.add(indexOfPriorities);
        priorities[indexOfPriorities] = -1;
      } else {
        queue.add(indexOfPriorities);
      }
    }
    return resultList.indexOf(location) + 1;
  }
}
