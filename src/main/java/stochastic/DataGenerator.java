package stochastic;

import com.sun.javafx.binding.StringFormatter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by kuba on 2015-05-02.
 */
public class DataGenerator {

    private final static int AD_PROFIT_LIMIT = 100;

    public List<Advertisement> generateAds(int size) {
        List<Advertisement> ads = new ArrayList<Advertisement>();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            ads.add(new Advertisement(r.nextInt(30)+1, r.nextDouble()*10));
        }

        return ads;
    }

    public void saveDataToFile(int size, int limitDown, int limitUp) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(StringFormatter.format("data_%d_%d_%d.txt", size, limitDown, limitUp).getValue());
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            out.println((r.nextInt(limitUp-limitDown) + limitDown) + " " + (r.nextDouble()*AD_PROFIT_LIMIT));
        }
        out.close();
    }
}
