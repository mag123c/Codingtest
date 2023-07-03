import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int channel = Integer.parseInt(br.readLine());
        int brokenBtn = Integer.parseInt(br.readLine());
        int[] brokenBtnArr = new int[10];

        if(brokenBtn > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < brokenBtn; i++) {
                int number = Integer.parseInt(st.nextToken());
                brokenBtnArr[number]--;
            }
        }

        //+- 눌려서 이동하는 거리
        int answer = Math.abs(channel - 100);
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 1000000; i++) {
            sb.append(String.valueOf(i));
            int length = sb.length();
            boolean chk = false;

            for(int j = 0; j < length; j++) {
                if(brokenBtnArr[sb.charAt(j) - '0'] == -1) {
                    chk = true;
                    break;
                }
            }

            if(!chk) {
                //+-이동과 버튼 눌렸을 때의 합
                answer = Math.min(Math.abs(channel - i) + length, answer);
            }

            sb.setLength(0);

        }

        System.out.println(answer);

    }

}
