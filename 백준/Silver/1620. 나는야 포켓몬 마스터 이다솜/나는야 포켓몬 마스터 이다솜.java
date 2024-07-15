import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 포켓몬 이름 입력받을 횟수
        int m = Integer.parseInt(st.nextToken());   // 문제 수

        // HashMap을 통해 index, 포켓몬 이름 저장
        HashMap<Integer, String> nameMap1 = new HashMap<>();
        HashMap<String, Integer> nameMap2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameMap1.put(i, name);  // 숫자로 입력 받았을 경우
            nameMap2.put(name, i);  // 문자로 입력 받았을 경우
        }

        // 문제 입력
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            // 입력 받은 것이 숫자
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                bw.write(nameMap1.get(Integer.parseInt(s))+"\n");
            }
            // 입력 받은 것이 문자열
            else
                bw.write(nameMap2.get(s)+"\n");
        }

        bw.flush();
        bw.close();
    }
}
