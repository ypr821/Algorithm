/*
  해시문제 길래 해시맵으로 풀어봤는데 첫번째 풀이는 속도도 늦고 답도 없어서 방법을 다르게 해서 풀어봤습니다.
  그런데 밑에 풀이도 문제 통과를 하지 못했습니다다.
*/


import java.util.Set;
import java.util.HashSet;


class Solution {

  public boolean solution(String[] phoneBook) {
    int firstLength = phoneBook[0].length();
    Set<String> set = new HashSet<>();

    for (int i = 0; i < phoneBook.length; i++) {
      if (i == 0) {
        continue;
      }
      set.add(phoneBook[i].substring(0, firstLength));
    }
    return !set.contains(phoneBook[0]);
  }
}

// 다른 사람 풀이.1 - 문제 개정되고나서는 통과가 안되지만 신기해서 가져왔습니다.
/*링크를 못찾아서 코드를 우선 주석 처리했습니다.

class Solution {
  public boolean solution(String[] phoneBook) {
    for(int i=0; i<phoneBook.length-1; i++) {
      for(int j=i+1; j<phoneBook.length; j++) {
        if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
        if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
      }
    }
    return true;
  }
}
*/

// 다른 사람 풀이.2

/* 링크를 못찾아서 코드를 우선 주석 처리했습니다.
import java.util.Arrays;

class Solution {
  public boolean solution(String[] phone_book) {
    boolean answer = true;

    Arrays.sort(phone_book);

    for(int i=0; i<phone_book.length-1; i++) {
      //정렬을 했으니까 앞 뒤로 검색하면서 시작하는 게 같으면...무조건 false반환하면 됩니다.
      if(phone_book[i+1].startsWith(phone_book[i])){
        answer = false;
        break;
      }
    }
    return answer;
  }
}
*/
