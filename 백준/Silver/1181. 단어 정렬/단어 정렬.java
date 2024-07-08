import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 문자열을 담을 배열 선언
        String[] word = new String[n];

        // 각 문자열 배열 저장
        for (int i = 0; i < n; i++) {
            word[i] = sc.next();
        }

        // 배열 정렬
        Arrays.sort(word, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // 만약 단어 길이가 같은 경우
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                // 길이가 다른 경우
                else
                    return s1.length() - s2.length();
            }
        });

        // 출력 + 만약 중복되면 중복 단어 출력 X
        String prev="";
        for (int i = 0; i < n; i++) {
            if (!word[i].equals(prev)) {
                System.out.println(word[i]);
                prev = word[i];
            }
        }

        sc.close();
    }
}