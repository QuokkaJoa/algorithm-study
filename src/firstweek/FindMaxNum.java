package firstweek;

//def find_max_num(array):
//    # 이 부분을 채워보세요!
//    return 1
//
//
//print("정답 = 6 / 현재 풀이 값 = ", find_max_num([3, 5, 6, 1, 2, 4]))
//print("정답 = 6 / 현재 풀이 값 = ", find_max_num([6, 6, 6]))
//print("정답 = 1888 / 현재 풀이 값 = ", find_max_num([6, 9, 2, 7, 1888]))

public class FindMaxNum {

  public static void main(String[] args) {
    System.out.println("정답 = 6 / 현재 풀이 값 = " + solution(new int[]{3, 5, 6, 1, 2, 4}));
    System.out.println("정답 = 6 / 현재 풀이 값 = " +solution(new int[]{6, 6, 6}));
    System.out.println("정답 = 1888 / 현재 풀이 값 = " +solution(new int[]{6, 9, 2, 7, 1888}));
  }

  public static int solution(int[] array) {
    int result = array[0];

    for (int i : array) {
      if (result < i) {
        result = i;
      }
    }

    return result;
  }
}
