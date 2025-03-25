# Merge Sorted Array 풀이

## 문제 설명

#### 두 개의 정수 배열 nums1과 nums2가 주어지며, nums1과 nums2의 요소 수를 각각 나타내는 정수 m과 n이 주어집니다.

#### 최종 정렬된 배열은 함수에 의해 반환되지 않고 nums1 내부에 저장되어야합니다.
#### 이를 수용하기 위해 nums1은 m + n의 길이를 가지며, 첫번째 m 요소는 병합할 요소를 나타내고 마지막 n 요소는 0으로 설정되므로 무시해야합니다.
#### nums2의 길이는 n입니다.
## 예제

### Example 1

> **Input:** `nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3`  
> **Output:** `[1,2,2,3,5,6]`  
> **Explanation:** The arrays we are merging are `[1,2,3]` and `[2,5,6]`.   
The result of the merge is `[1,2,2,3,5,6]` with the underlined elements coming from nums1.

### Example 2
> **Input:** `nums1 = [1], m = 1, nums2 = [], n = 0`  
> **Output:** `[1]`  
> **Explanation:** The arrays we are merging are `[1]` and `[]`.  
The result of the merge is `[1]`.

### Example 3
> **Input:** `nums1 = [0], m = 0, nums2 = [1], n = 1`  
> **Output:** `[1]`  
> **Explanation:** The arrays we are merging are `[]` and `[1]`.  
The result of the merge is `[1]`.  
Note that because `m = 0`, there are no elements in `nums1`.   
The 0 is only there to ensure the merge result can fit in `nums1`.

---
## 풀이 과정 (Two Pointer)
### 접근방법
#### 문제를 에제에 맞춰서 간단히 다시 정리해보겠습니다.
- 두개의 정렬된 배열이 있습니다 각 배열에서 의미 있는 요소의 갯수를 각각 m,n으로 지정합니다.(의미 없는 요소는 0으로 지정합니다)
- ex) nums1는 의미있는 요소 `[1,2,3]` 제외 한 나머지 3개의 요소는 빈값입니다. 반면에 nums2는 `[2,5,6]` 모두 의미있는 값입니다.
<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
</code>
</pre>
- nums1과 nums2를 조합해서 최종 정렬된 배열 nums1을 만들겁니다.

<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
Input: nums1 = [1,2,2,3,5,6]
</code>
</pre>
- 결과를 만들기 위해 우리는 3가지의 값을 알아야합니다
1. nums1의 의미 있는 값의 인덱스 i
2. nums2의 의미 있는 값의 인덱스 j
3. nums1 + nums2 마지막 인덱스 k (비어있는 값 중 큰 수를 집어넣기 위한 목적)

<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
// nums1의 유효한 요소는 m - 1
int i = 2;

// nums2의 유효한 요소는 n - 1
int j = 2;

// nums1 + nums2의 유효한 요소는 m + n - 1
int k = 3;
</code>
</pre>

이제 만들어진 3개의 포인터로 nums1 배열을 재정립 해볼겁니다.

- i와 j의 요소 비교
- 둘 중 큰 수를 k에 대입
- k 그리고 i와 j중 대입된 값에 해당하는 (j or i) 포인터를 앞으로 당김

<pre style="background:#2d2d2d; color:white; padding:0.5em 1em; margin: 0; width:100%; overflow:auto; font-size: 14px; line-height: 1.4;">
<code>
i = 2
j = 2
k = 5

nums1 = [1,2,3,0,0,0]
             i     k
nums2 = [2,5,6]
             j

             ↓ 6은 3보다 큼 

nums1 = [1,2,3,0,0,6]
             i   k
nums2 = [2,5,6]
           j

            ↓ 6는 5보다 큼

nums1 = [1,2,3,0,5,6]
             i k
nums2 = [2,5,6]
         j
            ↓ 3은 2보다 큼

nums1 = [1,2,3,3,5,6]
           i  
             k
nums2 = [2,5,6]
         j
            ↓ 2 = 2 값이 같은 경우에는 nums2의 값을 채움(nums1의 값을 채워도 어차피 끝까지 가면 다 정렬됨)

j가 끝남 while문 종료 결과
nums1 = [1,2,2,3,5,6]
</code>
</pre>
