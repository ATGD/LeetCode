import java.text.DecimalFormat;

public class Test {

    public static void main(String[] args) {
        String format = new DecimalFormat("0000").format(Integer.parseInt("1045"));
        System.out.println(format);
    }
}
