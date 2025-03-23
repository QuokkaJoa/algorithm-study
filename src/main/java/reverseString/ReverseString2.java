package reverseString;

//문자열 s와 정수 k가 주어졌을 때, 문자열의 시작부터 2k개의 문자를 셀 때마다 첫 번째 k개의 문자를 역으로 바꿉니다.
//k개 미만의 문자가 남아 있으면 모두 되돌립니다. 2k 미만이지만 k개 이상의 문자가 있는 경우 처음 k개의 문자를 되돌리고 나머지 문자는 원래 문자로 남겨둡니다.
public class ReverseString2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseString(s, k));
    }

    public static String reverseString(String s, int k) {
        char[] stringToChar = s.toCharArray();
        for (int i = 0; i < stringToChar.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, stringToChar.length - 1);
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
}
