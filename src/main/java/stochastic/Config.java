package stochastic;

/**
 * Created with IntelliJ IDEA.
 * User: maciejprokopiuk
 * Date: 10/05/15
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    private static Double punishment = 100.00;
    public static String fileName = "data.txt";

    public static Double getPunishment() {
        return punishment;
    }

    public static long getNumberOfCachedSolutions() {
        return 10;  //To change body of created methods use File | Settings | File Templates.
    }

    public static String getFileName() {
        return fileName;
    }
}
