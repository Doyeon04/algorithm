import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        int answer = 0;
        boolean prevIsMinus = false;
        String num = "";

        for(int i=0; i<=str.length; i++){
            if(i==str.length || str[i].equals("-") || str[i].equals("+")){ // 연산자라면
                if(!prevIsMinus){ // -가 나온적이 없다면
                    answer += Integer.parseInt(num);
                    num = "";
                }
                else{ // - 가 나온적이 있다면 그 다음도 -로 계산
                    answer -= Integer.parseInt(num);
                    num = "";
                }
                if(i!=str.length && str[i].equals("-")) prevIsMinus = true;
            }
            else{ // 연산자가 아니라 문자라면
                num += str[i];
            }
        }
        System.out.println(answer);
    }
}