# Input Array is Sorted 풀이

## 문제 설명

1부터 시작하는 인덱스를 가진 정수 배열 numbers가 주어집니다. 이 배열은 이미 오름차순(비감소순)으로 정렬되어 있습니다.

두 수의 합이 되어야 하는 정수 target이 주어집니다.

배열 numbers에서 두 개의 수를 찾아서, 이 두 수의 합이 target과 정확히 일치하도록 해야 합니다.

이때 두 수를 각각 numbers[index1]와 numbers[index2]라고 할 때, 조건은 1 <= index1 < index2 <= numbers.length 입니다.

반환 시, 인덱스는 1부터 시작하는 번호로 출력해야 하므로, 두 인덱스를 [index1, index2] 형태의 길이 2짜리 정수 배열로 반환합니다.

문제에서 주어진 테스트 케이스는 정확히 하나의 해답만 존재하도록 보장됩니다.

같은 요소를 두 번 사용하는 것은 허용되지 않습니다.

추가 사용 가능한 공간: 상수 공간(constant extra space)만 사용할 수 있습니다. 즉, 배열이나 리스트와 같이 추가적으로 메모리를 많이 사용하지 않아야 합니다.

---
### Example 1

> Input: `numbers = [2,7,11,15], target = 9`  
> Output: `[1,2]`    
> Explanation: The sum of 2 and 7 is 9. Therefore, `index1 = 1, index2 = 2.` We return `[1, 2]`.  

### Example 2
> Input: `numbers = [2,3,4], target = 6`  
> Output: `[1,3]`  
> Explanation: The sum of 2 and 4 is 6. Therefore `index1 = 1, index2 = 3.` We return `[1, 3]`.

### Example 3
> Input: `numbers = [-1,0], target = -1`  
> Output: `[1,2]`  
> Explanation: The sum of -1 and 0 is -1. Therefore `index1 = 1, index2 = 2`. We return `[1, 2]`.

--- 
## 풀이 과정 (Two Pointer)
### 접근방법
- 주어진 예제 배열의 첫번째 인덱스와 마지막 인덱스를 나타내는 포인터 두개를 생성합니다.(left, right)
<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
target = 9

[2, 7, 11, 15]
 L          R
</code>
</pre>
- 두개의 포인터가 서로 교차되지 않을만큼만 가까워지며 배열을 순회합니다. 이때 순회할때 3가지 선택지를 갖습니다.
1. 두 요소의 합이 target 보다 크면 오른쪽 포인터를 1 감소시킵니다.
2. 두 요소의 합이 target과 같으면 `return new int[]{left + 1, right + 1}`을 해줍니다.
→ left+1과 right+1을 반환하는 이유는 문제가 index+1이 되는 정수 배열을 반환하고싶어하기 때문입니다.
3. 두 요소의 합이 target보다 작으면 왼쪽 포인터를 1 증가시킵니다.
<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
target = 9

[2, 7, 11, 15]
 L          R

      ↓ 2 + 15 > 9(target)

[2, 7, 11, 15]
 L      R

      ↓ 2 + 11 > 9(target)

[2, 7, 11, 15]
 L  R    

      ↓ 2 + 7 = 9(target)
        left = 0
        right = 1

return new int[]{0 + 1, 1 + 1}

return new int[]{1, 2}
</code>
</pre>

---
### 왜 while문 바깥의 return은 null을 했나요?
문제의 요건 상 정확히 하나의 해답이 보장되기 때문입니다 while문 바깥의 return은 실행되지 않습니다.
