//package com.example.inflearnb.book;


class Solution {

  public String[] solution(int startNumber, int endNumber) {
    String[] answers = new String[Math.abs(startNumber - endNumber) + 1];
    String answer = "";

    if (startNumber > endNumber) {
      answers = countDown(startNumber, endNumber, answers);
    } else if (startNumber < endNumber) {
      answers = countUp(startNumber, endNumber, answers);

    } else { // 두 숫자가 같을 경우
      answers[0] = "000000000" + startNumber;
    }

    return answers;
  }

  public String[] countDown(int startNumber, int endNumber, String[] answers) {
    String str = "";
    for (int i = 0; i <= startNumber - endNumber; i++) {
      str += (startNumber - i);
      String zeroString = getZeroString(i);
      answers[i] = zeroString + str;
      //System.out.println(answers[i]);
    }
    return answers;
  }

  public String getZeroString(int num) {
    String zreoStr = "";
    for (int i = 0; i < 9 - num; i++) {
      zreoStr += "0";
    }
    return zreoStr;
  }

  public String[] countUp(int startNumber, int endNumber, String[] answers) {
    String str = "";
    for (int i = 0; i <= endNumber - startNumber; i++) {
      str += (startNumber + i);
      String zeroString = getZeroString(i);
      answers[i] = zeroString + str;
      //System.out.println(answers[i]);
    }
    return answers;
  }

}


















