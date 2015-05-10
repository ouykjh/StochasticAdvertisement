package stochastic;

import java.util.*;

/**
 * Created by kuba on 2015-05-02.
 */
public class DataGenerator {

    public List<Advertisement> generateAds(int size) {
        List<Advertisement> ads = new ArrayList<Advertisement>();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            ads.add(new Advertisement(r.nextInt(10), r.nextGaussian()));
        }

        return ads;
    }
}
