//처음 내가 푼.. 풀이
import java.util.ArrayList;
import java.util.List;

class Solution {
  public String solution(String new_id) {
    String answer = "";
    new_id = new_id.toLowerCase();

    for(int i=0;i < new_id.length(); i++){
      char new_idChar = new_id.charAt(i);
      if(new_idChar >= 'a' && new_idChar<='z') answer += new_id.charAt(i);
      else if(new_idChar >= '0' && new_idChar<='9') answer += new_id.charAt(i);
      else if(new_idChar == '-' || new_idChar == '_' ||new_idChar == '.' ) answer += new_id.charAt(i);
    }
    while(answer.contains("..")){
      answer = answer.replace("..",".");
    }
    if(answer.indexOf('.') == 0){
      answer = answer.substring(1,answer.length());
    }
    if(answer.length() >15){
      answer = answer.substring(0,15);
    }

    if(answer.length() < 1){
      answer = "a";
    }
    if(answer.length() >=1){
      if(answer.lastIndexOf('.') == answer.length()-1){
        answer = answer.substring(0,answer.length()-1);
      }
      while(answer.length() < 3){
        answer += answer.charAt(answer.length()-1);
      }
    }
    return answer;
  }
}

//문화충격받은 다른 사람 코드
//출처 : https://programmers.co.kr/learn/courses/30/lessons/72410/solution_groups?language=java
class Solution {
  public String solution(String new_id) {

    String s = new KAKAOID(new_id)
        .replaceToLowerCase()
        .filter()
        .toSingleDot()
        .noStartEndDot()
        .noBlank()
        .noGreaterThan16()
        .noLessThan2()
        .getResult();


    return s;
  }

  private static class KAKAOID {
    private String s;

    KAKAOID(String s) {
      this.s = s;
    }

    private KAKAOID replaceToLowerCase() {
      s = s.toLowerCase();
      return this;
    }

    private KAKAOID filter() {
      s = s.replaceAll("[^a-z0-9._-]", "");
      return this;
    }

    private KAKAOID toSingleDot() {
      s = s.replaceAll("[.]{2,}", ".");
      return this;
    }

    private KAKAOID noStartEndDot() {
      s = s.replaceAll("^[.]|[.]$", "");
      return this;
    }

    private KAKAOID noBlank() {
      s = s.isEmpty() ? "a" : s;
      return this;
    }

    private KAKAOID noGreaterThan16() {
      if (s.length() >= 16) {
        s = s.substring(0, 15);
      }
      s = s.replaceAll("[.]$", "");
      return this;
    }

    private KAKAOID noLessThan2() {
      StringBuilder sBuilder = new StringBuilder(s);
      while (sBuilder.length() <= 2) {
        sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
      }
      s = sBuilder.toString();
      return this;
    }

    private String getResult() {
      return s;
    }
  }
}