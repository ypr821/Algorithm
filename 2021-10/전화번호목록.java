//첫번째 문제 풀이

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;


class Solution {

  public boolean solution(String[] phone_book) {

    if (checkNumber(phone_book) != 0) {
      return false;
    } else {
      return true;
    }
  }

  public int checkNumber(String[] phone_book) {
    int firstLength = phone_book[0].length();
    Map<String, String> map = new HashMap<>();

    for (int i = 0; i < phone_book.length - 1; i++) {
      map.put((i + 1) + "", phone_book[i + 1].substring(0, firstLength));
    }
    Map<String, String> filteredMap = map.entrySet().stream()
        .filter(phoneNumber -> phone_book[0].equals(phoneNumber.getValue()))
        .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

    return filteredMap.size();
  }
}

///////////////////////////////////////////////////////////////////////////////
/*
  다시 푼 문제 풀이 ..
  해시문제 길래 해시맵으로 풀어봤는데 첫번째 풀이는 속도도 늦고 답도 없어서 방법을 다르게 해서 풀어봤다.
  그런데 밑에 풀이도 문제 통과를 하지 못했다. 왜지??왜 안되는 걸까?????ㅜㅜ
*/


import java.util.Set;
    import java.util.HashSet;


class Solution {

  public boolean solution(String[] phone_book) {
    int firstLength = phone_book[0].length();
    Set<String> set = new HashSet<>();

    for (int i = 0; i < phone_book.length; i++) {
      if (i == 0) {
        continue;
      }
      set.add(phone_book[i].substring(0, firstLength));
    }
    if (set.contains(phone_book[0])) {
      return false;
    } else {
      return true;
    }

  }

}

//다른 사람 풀이.1 - 문제 개정되고나서는 통과가 안되지만 신기해서 가져왔다.

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


//다른 사람 풀이.2
import java.util.Arrays;

class Solution {
  public boolean solution(String[] phone_book) {
    boolean answer = true;

    Arrays.sort(phone_book);

    for(int i=0; i<phone_book.length-1; i++) {
      if(phone_book[i+1].startsWith(phone_book[i])){
        answer = false;
        break;
      }
    }
    return answer;
  }
}
