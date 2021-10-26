package com.example.inflearnb.book;

class Solution3 {

  public static int solution(int[] sortedArray, int findValue) {
    int answer = 0;
    int sortedArrayLength = sortedArray.length;
    int halfLength = sortedArray.length / 2;

    if (sortedArray[halfLength] > findValue) {
      answer = check(halfLength, sortedArrayLength, sortedArray, findValue);

    } else if (sortedArray[halfLength] < findValue) {
      answer = check(0, halfLength, sortedArray, findValue);

    } else if (sortedArray[halfLength] == findValue) {
      answer = halfLength;
    }
    return answer;
  }

  public static int check(int start, int finish, int[] sortedArray, int findValue) {
    int num = 0;
    for (int i = start; i < finish; i++) {
      if (sortedArray[i] == findValue) {
        num = i;
      }
    }
    return num;
  }
}
