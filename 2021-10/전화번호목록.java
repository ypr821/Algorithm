//첫번째 문제 풀이

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Map.Entry;


class Solution {

  public boolean solution(String[] phoneBook) {

    return checkNumber(phone_book) == 0;
  }

  public int checkNumber(String[] phoneBook) {
    int firstLength = phoneBook[0].length();
    Map<Integer, String> map = new HashMap<>();

    for (int i = 0; i < phoneBook.length - 1; i++) {
      map.put(i + 1, phoneBook[i + 1].substring(0, firstLength));
    }
    return map.entrySet().stream()
        .filter(phoneNumber -> phoneBook[0].equals(phoneNumber.getValue()))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue))
        .size();
  }
}
