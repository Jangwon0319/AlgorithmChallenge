import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //테스트 횟수

        for (int i = 0; i < N; i++) {
            String str = br.readLine();     // 괄호 입력
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;    // VPS 여부 확인

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                // 만약 "("인 경우 push
                if (ch == '(') {
                    stack.push(ch);
                }
                // 만약 ")"인 경우
                else if (ch == ')') {
                    // Stack 안에 아무것도 없을 경우
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    // Stack 안에 "("가 존재할 경우
                    else {
                        stack.pop();
                    }
                }
            }

            // 마지막 체크
            if (flag && stack.isEmpty()) {
                bw.write("YES\n");
            }
            else
                bw.write("NO\n");
        }

        bw.flush();
        bw.close();

    }
}
