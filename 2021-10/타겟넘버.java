import java.util.*;

class Solution {

  public int solution(int[] numbers, int target) {
    int answer = 0;


    //모든 경우 검색
    //조건처리 (타겟과 값이 같다면) {count++}
    int count = 0;

    for (int i = 0; i < numbers.length; i++) {
      for () {
        int result = 0;

        if (result == target) {
          count++;
        }
      }
    }
    return answer;
  }
}
////////////////////////////////////////////////////////////////////////////////

//모든 경우의 수를 탐색할 때는 재귀함수를 쓰는 구나 배웠다.
//힌트를 얻었으니 코드를 다시 짜보자
class Solution {

  public int solution(int[] numbers, int target) {
    int answer = dfs(numbers, 0, 0, target);

    return answer;
  }

  public int dfs(int[] numbers, int index, int sum, int target) {
    if(index >= numbers.length){
      if(target == sum){
        return 1;
      }else{
        return 0;
      }
    }
    return dfs(numbers, index, sum + numbers[index], target) + dfs(numbers, index,
        sum - numbers[index], target);
  }
}

//////////////////////////////////////////////////////////////////////
class Solution {

  public int dfs(int prev, int index, int[] numbers, int target) {
    if (index >= numbers.length) {
      if (target == prev) {
        return 1;
      }
      return 0;
    }
    int cur1 = prev + numbers[index];
    int cur2 = prev - numbers[index];
    int ans = 0;
    ans += dfs(cur1, index + 1, numbers, target);
    ans += dfs(cur2, index + 1, numbers, target);
    return ans;
  }

  public int solution(int[] numbers, int target) {
    int current = numbers[0];
    int answer = 0;
    answer += dfs(current, 1, numbers, target);
    answer += dfs(-current, 1, numbers, target);
    return answer;
  }
}

출처:https://www.pymoon.com/entry/Programmers-타겟-넘버-BFSDFS-Java-풀이 [파이문]

class Solution {

  public int solution(int[] numbers, int target) {
    int answer = dfs(numbers, 0, 0, target);
    return answer;
  }

  public int dfs(int[] numbers, int depth, int sum, int target) {
    if (depth == numbers.length) {
      if (target == sum) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return dfs(numbers, depth + 1, sum + numbers[depth], target) + dfs(numbers, depth + 1,
          sum - numbers[depth], target);
    }
  }
}
