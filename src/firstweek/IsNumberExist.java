package firstweek;


//def is_number_exist(number, array):
//    # 이 부분을 채워보세요!
//    return True
//
//
//    result = is_number_exist
//print("정답 = True 현재 풀이 값 =", result(3, [3,5,6,1,2,4]))
//print("정답 = Flase 현재 풀이 값 =", result(7, [6,6,6]))
//print("정답 = True 현재 풀이 값 =", result(2, [6,9,2,7,1888]))
public class IsNumberExist {

  public static void main(String[] args) {
    System.out.println("정답 = True 현재 풀이 값 =" + solution(3, new int[]{3,5,6,1,2,4}));
    System.out.println("정답 = False 현재 풀이 값 =" + solution(7, new int[]{6, 6, 6}));
    System.out.println("정답 = True 현재 풀이 값 =" + solution(2, new int[]{6,9,2,7,1888}));
  }

  public static boolean solution(int number, int[] array) {
    boolean result = false;
    for (int i : array) {
      if (number == i) {
        result = true;
      }
    }
    return result;
  }
}
