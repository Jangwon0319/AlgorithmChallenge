import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            // "0 0 0" 입력 되면 종료
            if (a == 0 && b == 0 && c == 0)
                break;

            int max = Math.max(a, Math.max(b, c));

            // 피타고라스 정리 활용
            if (max == a){
                if (Math.pow(a,2) == Math.pow(b,2) + Math.pow(c,2))
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }

            else if (max == b){
                if (Math.pow(b,2) == Math.pow(a,2) + Math.pow(c,2))
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }

            else {
                if (Math.pow(c,2) == Math.pow(b,2) + Math.pow(a,2))
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }
        }

    }
}