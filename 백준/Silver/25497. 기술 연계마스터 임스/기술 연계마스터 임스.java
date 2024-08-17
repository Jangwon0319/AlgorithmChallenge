import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 총 기술 사용 횟수

        String skill = br.readLine();
        Deque<Character> LR = new ArrayDeque<>();
        Deque<Character> SK = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = skill.charAt(i);

            if (Character.isDigit(ch)) {
                count++;
            }
            else if (ch == 'S') {
                SK.push(ch);
            }
            else if (ch == 'L') {
                LR.push(ch);
            }
            else if (ch == 'R') {
                if (!(LR.isEmpty())) {
                    LR.pop();
                    count++;
                }
                else
                    break;
            }
            else if (ch == 'K') {
                if (!(SK.isEmpty())) {
                    SK.pop();
                    count++;
                }
                else
                    break;
            }
        }

        System.out.println(count);

    }
}
