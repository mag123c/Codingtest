import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        print("|\\_/|\n", bw);
        print("|q p|   /}\n", bw);
        print("( 0 )\"\"\"\\\n", bw);
        print("|\"^\"`    |\n", bw);
        print("||_/=\\\\__|\n", bw);


        bw.flush();
        bw.close();
    }

    public static void print(String tmp, BufferedWriter bw) throws IOException {
        bw.write(tmp);
    }
}