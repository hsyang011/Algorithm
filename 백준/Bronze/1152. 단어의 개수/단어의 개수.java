import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine().trim();
        System.out.println(str.length() == 0 ? 0 : str.split(" ").length);
    }
}