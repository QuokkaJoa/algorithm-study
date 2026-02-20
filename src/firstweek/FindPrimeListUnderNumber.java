package firstweek;

//input = 20
//
//
//def find_prime_list_under_number(number):
//    # 이 부분을 채워보세요!
//    return []
//
//
//result = find_prime_list_under_number(input)
//print(result)

import java.util.ArrayList;
import java.util.List;

//1. 소수는 본인과 1을 제외하고는 나누어떨어질수없다(= 나머지가 0이 될수 없다)
public class FindPrimeListUnderNumber {

  public static List<Integer> findPrimeListUnderNumber(int number) {
    // 일단 소수를 찾기 위해 number이하인 for 루프를 돌아야함
    // 소수를 판별하기 위한 조건 1. 합성수들은 비교할 필요가없다 ex) 6 같은경우에는 2x3으로 만들어진 합성수기 때문에 비교를 할 필요가 없음 고로 list에 추가된 소수들하고만 비교해도됨
    // 소수를 판별하기 위한 조건 2. 소수 list의 수를 제곱했더니 현재수(n) 보다 작으면 수사 범위임 왜냐면 현재 수보다 커버리면 현재 수(i)가 n의 약수중 큰쪽으로 가버리기 때문임
    // 소수를 판별하기 위한 조건 3. n 나누기 소수 list의 수를 하면 나머지가 0이면 소수가 아님
    // 소수를 판별하기 위한 조건 4. 2,3번을 모두 만족해야함
    ArrayList<Integer> primeList = new ArrayList<>();
    for (int n = 2; n <= number; n++) {
      boolean isPrime = true;
      for (Integer i : primeList) {
        if (i * i <= n && n % i == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        primeList.add(n);
      }
    }
    return primeList;
  }
  public static void main(String[] args) {
    int input = 20;
    List<Integer> result = findPrimeListUnderNumber(input);
    System.out.println(result);
  }
}
