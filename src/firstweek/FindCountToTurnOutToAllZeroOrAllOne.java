package firstweek;
//input = "011110"
//
//
//def find_count_to_turn_out_to_all_zero_or_all_one(string):
//    # 이 부분을 채워보세요!
//    return 1
//
//
//result = find_count_to_turn_out_to_all_zero_or_all_one(input)
//print(result)
public class FindCountToTurnOutToAllZeroOrAllOne {

  public static void main(String[] args) {
    System.out.println(solution("0001100"));
  }

  public static int solution(String str) {
    int countToAllZero = 0;
    int countToAllOne = 0;

    if (str.charAt(0) == '0') {
      countToAllOne += 1;
    } else if (str.charAt(0) == '1') {
      countToAllZero += 1;
    }

    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) != str.charAt(i + 1)) {
        if (str.charAt(i + 1) == '1') {
          countToAllZero += 1;
        }
        if (str.charAt(i + 1) == '0') {
          countToAllOne += 1;
        }
      }
    }
    return Math.min(countToAllZero, countToAllOne);
  }
}
