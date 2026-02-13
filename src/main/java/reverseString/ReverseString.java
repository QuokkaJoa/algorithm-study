package reverseString;

public class ReverseString {

    public static void main(String[] args) {
//        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println(reverseString(s));
    }
    static char[] reverseString(char[] s) {
        int leftIndex = 0;
        int rightIndex = s.length - 1;

        while (leftIndex < rightIndex) {
            char originLeftIndex = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = originLeftIndex;
            leftIndex++;
            rightIndex--;
        }
        return s;
    }

}
