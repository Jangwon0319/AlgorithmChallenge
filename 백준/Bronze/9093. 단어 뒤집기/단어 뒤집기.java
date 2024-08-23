import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                Stack<Character> stack = new Stack<>();

                // 각 단어를 스택에 넣고 뒤집기
                for (char ch : word.toCharArray()) {
                    stack.push(ch);
                }

                // 스택에서 꺼내면서 단어 뒤집기
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }

                bw.write(" "); // 단어 뒤에 공백 추가
            }

            bw.newLine(); // 한 줄 끝나면 줄 바꿈
        }

        bw.flush(); // 버퍼에 남은 데이터 출력
        bw.close();

    }
}
