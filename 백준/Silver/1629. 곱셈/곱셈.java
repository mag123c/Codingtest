import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static long A;
    private static long B;
    private static long C;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(B));

    }

    public static long pow(long component) {
        if(component == 1) return A % C;

        long tmp = pow(component / 2);

        if(component % 2 == 0) return tmp * tmp % C;
        else return (tmp * tmp % C) * A % C;
    }
}
