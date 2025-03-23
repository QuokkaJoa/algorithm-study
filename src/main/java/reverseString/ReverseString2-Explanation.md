# Reverse String 풀이

## 문제 설명

문자열 `s`와 정수 `k`가 주어졌을 때, 문자열의 시작부터 `2k`개의 문자를 셀 때마다 첫 번째 `k`개의 문자를 역으로 바꿉니다.
`k`개 미만의 문자가 남아 있으면 모두 되돌립니다. `2k` 미만이지만 `k`개 이상의 문자가 있는 경우 처음 `k`개의 문자를 되돌리고 나머지 문자는 원래 문자로 남겨둡니다.
---

## 예제

### Example 1
```
Input: s = "abcdefg", k = 2 
Output: "bacdfeg"
```

### Example 2
```
Input: s = "abcd", k =2
Output: "bacd"
```

---

## 풀이 과정 (Two Pointer)

**문제 요건대로 문자열을 끊고 그 끊은 문자열 안에서 Two Pointer 기법을 사용하여 순회한 뒤 값을 뒤바꿔줍니다.**

main 메소드
```java
public static void main(String[] args) {
    String s = "abcdefg";
    int k = 2;
    System.out.println(reverseString(s, k));
}
```

reverseString 메소드

```java
public static String reverseString(String s, int k) {
    char[] stringToChar = s.toCharArray();
    for (int i = 0; i < stringToChar.length; i += 2 * k) {
        int left = i;
        int right = i + k - 1;
        while (left < right) {
            char originLeft = stringToChar[left];
            stringToChar[left] = stringToChar[right];
            stringToChar[right] = originLeft;
            left++;
            right--;
        }
    }
    return new String(stringToChar);
}
```
1. String 문자열은 배열처럼 쉽게 값의 위치를 바꿔줄 수 없기 때문에 추가 작업이 필요합니다 전 많은 방법중에서 String -> char[] 방법을 선택했습니다.
2. char[]을 순회할 for문을 만들어줍니다. 이때 for문의 i 조건은 배열을 순회하기 때문에 인덱스와 같은 역할로 간주합니다. 현재 char 배열은 ```char[] stringChar = {'a','b','c','d','e','f','g'}```입니다.
3. stringToChar 배열은 인덱스 0부터 배열요소의 갯수 - 1 까지 돌면 전체 요소를 다 돌 수 있습니다. `i < stringTochar.length`
4. 문제 요건을 보면 문자열을 끊는 조건은 `2k`개의 문자를 셀때마다 끊습니다 그러므로 `i` 값은 `2k`만큼 커지면서 배열을 순회해야 합니다. `i += 2 * k`
5. reverse 할땐 TwoPointer 를 사용합니다. left의 값은 각 문자열의 첫번째 인덱스 i, right는 각 문자열의 마지막 인덱스 `Math.min(i + k - 1, stringToChar.length - 1)` 입니다.
6. Two Pointer을 사용하여 포인터를 가운데로 모으면서 값을 서로 뒤바꿔줍니다.
---
### left가 i, right가 Math.min(i + k - 1, stringToChar.length - 1) 인 이유?
- 문제를 보면 문자열을 끊는 조건은 `2k` 지만 문자를 reverse할 조건은 `k` 입니다. Two Pointer를 사용하기 위해 우리는 reverse할 문자열의 첫 인덱스와 마지막 인덱스를 알아야합니다 그러므로 항상 문자열의 첫 인덱스가 되는 `i`는 left값에 대입하고 reverse할 문자의 갯수를 나타내는 `k`를 사용해 `i + k - 1`을 right에 대입해줍니다.
```
ex) k = 3 일때 (i = 0 기준)
char[] arr = {'a','b','c','e'}의 첫번째 값과 마지막 값을 알고싶다면?
첫번째 : arr[0] = a
두번째 : arr[0 + 3 - 1] = c
```
- 그러다가 만약 다뤄야할 문자 배열 요소의 수가 i + k - 1 보다 많아진다면?
```
k = 3
ex) 문자배열 : {'a','b'}
```
원래라면 인덱스 0 부터 인덱스 2까지의 값을 Two Pointer로 뒤바꿔줘야하지만 현재 존재하는 문자배열엔 인덱스 2가 존재하지 않습니다. 그러므로 배열의 마지막 인덱스인 stringToChar.length - 1 을 사용하는 것입니다.
