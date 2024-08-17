import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            // 스택 선언
            Deque<String> stack = new ArrayDeque<>();

            // 문자열 입력 및 토큰 분류
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            // 나눌 횟수 count 저장
            int count = st.countTokens();
            
            for (int j = 0; j < count ; j++) {
                stack.push(st.nextToken());
            }

            System.out.print("Case #" + (i+1) + ":");

            for (int j = 0; j < count ; j++) {
                System.out.print(" " + stack.pop());
            }

            System.out.println();
            
        }

    }
}
