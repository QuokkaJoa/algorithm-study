package firstweek;

//def find_max_occurred_alphabet(string):
//    # 이 부분을 채워보세요!
//    return "a"
//
//
//result = find_max_occurred_alphabet
//print("정답 = i 현재 풀이 값 =", result("hello my name is dingcodingco"))
//print("정답 = e 현재 풀이 값 =", result("we love algorithm"))
//print("정답 = b 현재 풀이 값 =", result("best of best youtube"))

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxOccurredAlphabet {
  public static void main(String[] args) {
    System.out.println("정답 = i 현재 풀이 값 = " + solution("hello my name is dingcodingco"));
    System.out.println("정답 = e 현재 풀이 값 = " + solution("we love algorithm"));
    System.out.println("정답 = b 현재 풀이 값 = " + solution("best of best youtube"));
  }

  public static char solution(String s) {
//    내풀이
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!Character.isLetter(c)) {
        continue;
      }
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort(
        (a, b) -> b.getValue() - a.getValue()
    );
    return list.get(0).getKey();

//    모범풀이
//    int[] alphabetOccurrenceArray = new int[26];
//
//    for (char c : s.toCharArray()) {
//      if (!Character.isLetter(c)) {
//        continue;
//      }
//      int arrIndex = c - 'a';
//      alphabetOccurrenceArray[arrIndex] += 1;
//    }
//
//    int maxOccurrence = 0;
//    int maxAlphabetIndex = 0;
//
//    for (int index = 0; index < alphabetOccurrenceArray.length; index++) {
//      int alphabetOccurrence = alphabetOccurrenceArray[index];
//
//      if (alphabetOccurrence > maxOccurrence) {
//        maxOccurrence = alphabetOccurrence;
//        maxAlphabetIndex = index;
//      }
//    }
//    return (char) (maxAlphabetIndex + 'a');
  }
}
