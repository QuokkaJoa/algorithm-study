package firstweek;


//def find_max_plus_or_multiply(array):
//    # 이 부분을 채워보세요!
//    return 1
//
//
//result = find_max_plus_or_multiply
//print("정답 = 728 현재 풀이 값 =", result([0,3,5,6,1,2,4]))
//print("정답 = 8820 현재 풀이 값 =", result([3,2,1,5,9,7,4]))
//print("정답 = 270 현재 풀이 값 =", result([1,1,1,3,3,2,5]))
public class FindMaxPlusOrMultiply {

  public static void main(String[] args) {
    System.out.println("정답 = 728 현재 풀이 값 = " + solution(new int[]{0,3,5,6,1,2,4}));
    System.out.println("정답 = 8820 현재 풀이 값 = " + solution(new int[]{3,2,1,5,9,7,4}));
    System.out.println("정답 = 270 현재 풀이 값 = " + solution(new int[]{1,1,1,3,3,2,5}));
  }

  private static int solution(int[] intArr) {
    int result = 0;
    for (int i : intArr) {
      if (result <= 1 || i <= 1) {
        result += i;
      } else {
        result *= i;
      }
    }
    return result;
  }

}
