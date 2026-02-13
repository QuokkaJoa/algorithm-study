# Max Consecutive Ones 문제풀이

## 문제

이진 배열 수와 정수 k가 주어졌을 때, 최대 k개의 0을 뒤집을 수 있다면 배열에서 연속된 1의 최대 개수를 반환합니다.

---

## 풀이 과정 (Sliding Window)
1. right는 계속 배열을 나아가면서 값이 0이나오면 zeros++, zeros < k 까지 maxLength를 저장
2. zeroes > k 되면 left를 zeros < k 까지 옮김
3. 1,2 반복
```
nums[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}

k = 2

1. right는 계속 배열을 나아가면서 zeros < k 까지 maxLength를 저장
ex) right = 0 and left = 0 이면 maxLength = 1
    zeros < k 까지 반복하면 첫번째 while문 실행시점은 
    left = 0, right 가 5일때임 while문은 zeros가 k보다 커질때 
    실행되므로 알맞은 배열의 길이는 zeors가 k와 같을 때임 
    즉 첫번째 maxLength는 5가 됨(left = 0, right = 4)
    
2. zeroes > k 되면 left를 zeros < k 까지 옮김
ex) right가 5일때 zeroes가 3임 목표치인 2가 초과됐으므로 left를 zeros가 2가 될때까지 옮겨줍니다 
그러면 left가 4이고 right가 5인 상태가됨

3. 1,2 반복
ex) left 옮기기 while문이 끝난 뒤 left = 4 right = 5 zero = 2 인 상태에서 다시 right가 배열을 나아감
right가 10일때 zeros가 3이 되므로 left가 이동하기전 
즉 while문이 실행되기전의 left = 4 , right = 9가 마지막 선택지였고
이전 maxLength인 5보다 큰 수 6이 저장되므로 maxLength는 6이 된다.

```
