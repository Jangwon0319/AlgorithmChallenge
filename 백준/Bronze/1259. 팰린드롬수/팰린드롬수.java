import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        while (true){
            String s = sc.nextLine();
            char[] arr = s.toCharArray();

            if (s.equals("0"))
                break;

            boolean temp = true;

            int len = arr.length;

            for (int i = 0; i < len / 2; i++){
                if (arr[i] != arr[len - 1 - i]){
                    temp = false;
                }
            }

            if (temp)
                System.out.println("yes");
            else
                System.out.println("no");

        }
    }
}