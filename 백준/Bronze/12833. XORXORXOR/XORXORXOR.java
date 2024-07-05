import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 줄로 입력 받기
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        // 입력을 공백 기준으로 나눠서 변수에 할당
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // XOR 연산
        int result;
        if (c % 2 == 0) {
            result = a;
        } else {
            result = a ^ b;
        }

        // 결과 출력
        System.out.println(result);

        br.close();
    }
}
