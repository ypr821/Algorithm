# 버블 정렬(bubble sort) 알고리즘
<br>
서로 인접한 두 원소를 검사하여 정렬하는 알고리즘 <br>
인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다.
<br><br>
  
  
  <img src="https://user-images.githubusercontent.com/56250078/136294071-73b42ee7-de6e-4a23-89f8-cd9708187378.png" width="50%" height="50%">
  
- 단순(구현 간단)하지만 비효율적인 방법 : 삽입 정렬, 선택 정렬, 버블 정렬
- 복잡하지만 효율적인 방법 : 퀵 정렬, 힙 정렬, 합병 정렬, 기수 정렬

<br><br>
  참고 : https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
<br><br>  
 
 
# Bubble sort Java code
  
```java
package bubbleSort;

public class BubbleSort2 {
  public int[] bubbleSort (int [] array){
    int length = array.length;
    for(int i = 0; i < length-1; i++){
      for(int j = 0; j < length-1; j++){
        if(array[j] > array[j+1]){
          int temp = array[j];
          //Swap numbers
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
    return array;
  }
}

//--------------------------------------------

package bubbleSort;

public class BubbleSort2 {
  public int[] bubbleSort (int [] array){
    int length = array.length;
    for(int i = 0; i < length-1; i++){
      for(int j = 0; j < length-1; j++){
        if(array[j] > array[j+1]){
          int temp = array[j];
          //Swap numbers
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
    return array;
  }
}
```

출처 : Udemy
Master the Coding Interview: Data Structures + Algorithms
