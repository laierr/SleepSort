import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,8,2,3,10,92,600,7,900,4,6,5};
        int[] b = new int[1000];

        for (int i = 0; i <1000 ; i++) {
            b[i] = (new Random().nextInt(1000)+1);
        }
        try {
            SleepSort.sort(b);
        } finally {

        }
    }
}
