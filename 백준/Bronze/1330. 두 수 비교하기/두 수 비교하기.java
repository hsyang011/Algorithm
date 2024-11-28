import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        String answer;
        if (a > b) {
            answer = ">";
        } else if (a < b) {
            answer = "<";
        } else {
            answer = "==";
        }
        
        System.out.println(answer);
    }
}