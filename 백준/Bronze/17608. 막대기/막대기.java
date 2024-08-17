import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int max = stack.pop();      
        int count = 1;

        for (int i = 0; i < n-1; i++) {
            if (max < stack.peek()) {
                count++;
                max = stack.pop();
            }
            else
                stack.pop();
        }

        System.out.println(count);

    }
}
