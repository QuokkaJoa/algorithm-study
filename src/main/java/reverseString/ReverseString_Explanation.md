# Reverse String 풀이

## 문제 설명

문자열을 반전시키는 함수를 작성하세요.  
입력 문자열은 문자 배열 `s` (`char[]`)로 주어집니다.  
**추가 메모리 없이 (O(1))**, 배열 자체를 **in-place로 수정**해야 합니다.

---

## 예제

### Example 1
```
Input: s = ["h", "e", "l", "l", "o"] Output: ["o", "l", "l", "e", "h"]
```

### Example 2
```
Input: s = ["H", "a", "n", "n", "a", "h"] Output: ["h", "a", "n", "n", "a", "H"]
```

---

## 풀이 과정 (Two Pointer)

**투 포인터(Two Pointer)** 기법을 사용하여 배열의 양 끝에서부터 문자를 바꿔나갑니다.

```java
int left = 0;
int right = s.length - 1;
```
1. 두 포인터가 서로 교차하기 전까지 반복합니다. (left < right)

2. 교환 전에 left의 값을 임시 변수에 저장합니다.

3. left에 right의 값을 대입합니다.

4. right에 임시 저장된 값을 대입합니다.

5. 포인터를 각각 left++, right-- 하여 가운데로 이동합니다.

```java
public void reverseString(char[] s) {
    int leftIndex = 0;
    int rightIndex = s.length - 1;

    while (leftIndex < rightIndex) {
        char originLeft = s[leftIndex];
        s[leftIndex] = s[rightIndex];
        s[rightIndex] = originLeft;

        leftIndex++;
        rightIndex--;
    }
}
```
