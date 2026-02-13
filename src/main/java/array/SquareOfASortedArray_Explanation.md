# Reverse String 풀이

## 문제 설명

#### 정수 배열 숫자가 감소하지 않는 순서로 정렬된 경우, 각 숫자의 제곱 배열을 감소하지 않는 순서로 정렬하여 반환합니다.

---

## 예제

### Example 1

> **Input:** `nums = [-4, -1, 0, 3, 10]`  
> **Output:** `[0, 1, 9, 16, 100]`  
> **Explanation:** After squaring, the array becomes `[16, 1, 0, 9, 100]`.  
> After sorting, It becomes `[0,1,9,16,100]`.



### Example 2
> **Input:** `nums = [-7, -3, 2, 3, 11]`  
> **Output:** `[4, 9, 9, 49, 121]`
---

## 풀이 과정 (Two Pointer)
### 접근방법
#### 주어진 예제의 Input 값은 다음과 같습니다

<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
Input: nums = [-4,-1,0,3,10]
</code>
</pre>
#### 제곱을 한다면 이런 값이 나옵니다
<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
-4 → 16
-1 → 1
 0 → 0
 3 → 9
10 → 100
</code>
</pre>

---
### 알 수 있는 점 2가지
1. 제곱을 한다면 양수인지 음수인지 체크할 필요가 없다
2. 가장자리에 있는 수가 제곱을 했을때 중앙의 수보다 크다

결론적으론 주어진 배열에서 요소의 절댓값이 크면 더 큰 수로 인식을 해야합니다. 

---

#### 위 두가지 속성을 이용해서 문제를 풀겠습니다.
먼저 새로운 배열을 생성하고 해당 배열을 순회할 0번째 index left와 마지막 인덱스 right 선언합니다.
- 여기서 새로 선언한 배열은 `int[] nums`의 요소를 제곲값으로 바꾸어 넣기 위해 만들었습니다.
<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
int[] res = new int[nums.length];
int left = 0;
int right = nums.length - 1;
</code>
</pre>

left,right 포인터로 배열을 순회하며 요소의 절대값이 작은지 큰지 가려내어 배열을 정렬해야합니다.
- left > right 일땐 left값을 제곱해서 마지막 인덱스에 넣습니다 그리고 left++ 합니다.
- right > left 일땐 right값을 제곱해서 마지막 인덱스에 넣습니다. 그리고 right--합니다.
<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>      
        절대값으로 변환 후

 nums=   [4,1,0,3,10]
          L        R

              ↓

         right > left

              ↓

  nums=  [4,1,0,3,10]
          L     R

  res=   [?,?,?,?,100]

              ↓

         left > right

  nums   [4,1,0,3,100]
            L   R

  res=   [?,?,?,16,100]

              ...
</code>
</pre>

---
### 왜 for문을 역순으로 돌리나요?
제곱을 하게되면 모든 값이 양수가 되고 값이 정렬되지 않은 상태로 바뀝니다. 정렬되지 않은 수로는 현재 사용하는 Two Pointer 방법으로 올바른 값을 낼 수 없습니다.

---
## 번외

## Java는 배열의 정렬을 위해 Arrays.sort() 메소드를 제공한다
이 메소드를 사용하면 배열을 단번에 정렬할 수 있습니다.

하지만 Arrays.sort()는 내부적으로 pivot 값을 생성해서 주어진 배열을 분할합니다 

pivot값 의 기준을 세우기 위해 배열의 전체를 한번 순회 후 → O(n)

배열을 pivot 기준으로 각 구간이 균등하게 반씩 나눕니다 → O(log n)

log n이 n 만큼 있으므로 시간복잡도가 O(n log n)이 됩니다.

하지만 문제는 O(n)으로 풀길 권장했습니다.
