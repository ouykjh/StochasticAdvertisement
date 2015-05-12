package stochastic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by kuba on 2015-05-02.
 */
public class DataGenerator {

    public List<Advertisement> generateAds(int size) {
        List<Advertisement> ads = new ArrayList<Advertisement>();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            ads.add(new Advertisement(r.nextInt(30)+1, r.nextDouble()*10));
        }

        return ads;
    }

    public void saveDataToFile(int size) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("data.txt");
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            out.println((r.nextInt(20)+10) + " " + (r.nextDouble()*40));
        }
        out.close();
    }
}
