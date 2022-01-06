/**
 * @author m809745357
 */
public class HelloCode {
    public static void main(String[] args) {
        int a = 10;
        for (int i = 3; i <= 100; i++) {
            a = a + i;
        }

        if (a > 10) {
            int b = a;
            int c = a + b;
            b ++;
        }
    }
}