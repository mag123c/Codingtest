import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String S = br.readLine();
        String[] SArr = S.split("");
        int length = S.length();

        int IOI = (N * 2) + 1;
        StringBuffer IOIsb = new StringBuffer();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < IOI; i ++) {
            if(i % 2 == 0) IOIsb.append("I");
            else IOIsb.append("O");
        }

        int cnt = 0;

        for(int i = 0; i <= length - IOI; i ++) {
            if(SArr[i].equals("O")) continue;

            for(int j = i; j < IOI + i; j ++) {
                sb.append(SArr[j]);
            }

            if(sb.toString().equals(IOIsb.toString())) cnt++;
            sb.setLength(0);
        }
        System.out.println(cnt);
    }
}