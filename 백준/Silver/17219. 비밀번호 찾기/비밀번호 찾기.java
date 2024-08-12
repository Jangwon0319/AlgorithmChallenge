import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 저장된 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken());   // 찾을려는 사이트 주소의 수

        // 주소와 비밀번호를 담을 해시 맵
        HashMap<String, String> map = new HashMap<>();


        // 주소, 비밀번호 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            map.put(st2.nextToken(), st2.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 찾을려는 주소의 비밀번호
        for (int i = 0; i < M; i++) {

            bw.write(map.get(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();

    }
}
