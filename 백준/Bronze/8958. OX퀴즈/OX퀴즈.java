import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 갯수
        int N = Integer.parseInt(br.readLine());

        // 문자열을 담을 배열
        String[] arr = new String[N];

        // 문자열 저장
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            int count = 0;  // 연속으로 맞춘 정답 횟수
            int sum = 0;    // 누적 점수

            for (int j = 0; j < arr[i].length(); j++) {

                if (arr[i].charAt(j) == 'O') {
                    count++;
                    sum += count;
                }
                else {
                    count = 0;
                }
            }

            System.out.println(sum);
        }
    }
}
