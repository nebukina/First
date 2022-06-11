import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData data = new AppData();
        data.readFile("test1.csv");
        System.out.println(Arrays.toString(data.getHeader()));
        System.out.println(Arrays.deepToString(data.getData()));

        data.writeData("test3.csv");
    }
}
