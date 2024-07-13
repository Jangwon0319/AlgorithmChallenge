import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 할 횟수
        int t = Integer.parseInt(br.readLine());
        
        // 테스트 케이스 입력
        for (int i = 0; i < t; i++) {
            // 수행할 함수 이름 입력
            String p = br.readLine();
            char[] ch = p.toCharArray();

            // 활용할 리스트 크기 입력
            int n = Integer.parseInt(br.readLine());

            // 배열 안에 값 입력 및 저장
            String input = br.readLine();
            input = input.substring(1, input.length() - 1); // 괄호 제거
            String[] arr = input.split(",");

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(arr[j]));
            }

            // 뒤집기, 에러 여부 확인
            boolean isReverse = false;
            boolean isError = false;

            // 함수 실행
            for (int j = 0; j < ch.length; j++) {
                // 일단 isReverse 상태 변경 -> 바꾸는 건 나중에
                if (ch[j] == 'R') {
                    isReverse = !isReverse;
                }
                else if (ch[j] == 'D') {
                    // list가 존재하지 않는데 삭제하면 에러
                    if (list.isEmpty()) {
                        isError = true;
                        break;
                    }
                    // 만약 list를 뒤집을 예정
                    else if (isReverse) {
                        // 바뀐다고 가정하면 맨 뒤가 뒤집었을 때 맨 앞 숫자가 된다.
                        list.remove(list.size() - 1);
                    }
                    else {
                        list.remove(0);
                    }
                }
            }

            // 에러 여부 및 뒤집기 실행
            if (isError){
                bw.write("error\n");
            }
            else {
                // isReverse가 참이면 바꿔준다
                if (isReverse){
                    Collections.reverse(list);
                }

                bw.write("[");
                for (int k = 0; k < list.size(); k++) {
                    bw.write(String.valueOf(list.get(k)));
                    if (k < list.size() - 1) {
                        bw.write(",");  // 마지막에 , 출력 x
                    }
                }
                bw.write("]");
                bw.write("\n");
            }

        }
        bw.flush();
        bw.close();

    }
}
