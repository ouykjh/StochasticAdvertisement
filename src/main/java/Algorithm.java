import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by kuba on 2015-05-02.
 */
public class Algorithm {

    private static final int PUNISHMENT = 1000;
    private List<Advertisement> ads;
    private int iterations;
    private int users;
    private Map<Double, List<Advertisement>> solutions;

    public Algorithm(List<Advertisement> ads, int iterations, int users) {
        this.ads = ads;
        this.iterations = iterations;
        this.users = users;
        solutions = new TreeMap<Double, List<Advertisement>>();
    }

    /* generate random solutions and crossover them (generation and crossover should be separate)*/
    public Map<Double, List<Advertisement>> execute() {
        for(int i =0; i<2*users; i++) {
            generateSolution();
        }

        Map<Double, List<Advertisement>> children = new TreeMap<Double, List<Advertisement>>();
        List<List<Advertisement>> childrenAds = new ArrayList<List<Advertisement>>(solutions.values());
        List<Advertisement> childSolution;

        for(int i=0; i<childrenAds.size(); i=i+2) {
            childSolution = crossover(childrenAds.get(i), childrenAds.get(i+1));
            children.put(calculateProfit(childSolution), childSolution);
        }

        return children;
    }


    /*generate list of random solutions, profit is calculating with over-limit punishment*/
    public void generateSolution() {
        Advertisement ad;
        List<Advertisement> solution = new ArrayList<Advertisement>();
        double profit = 0;

        for(int i=0; i<iterations; i++) {
            ad = randomAd();
            ad.setAmount(ad.getAmount()+1);
            solution.add(ad);
            if(ad.getAmount() > ad.getLimit()) {
                profit = ad.getProfit()*PUNISHMENT;
            } else {
                profit += ad.getProfit();
            }
        }
        solutions.put(profit, solution);
    }

    private Advertisement randomAd() {
        Random r = new Random();
        return ads.get(r.nextInt((ads.size()-1)));
    }

    private List<Advertisement> crossover(List<Advertisement> ads1, List<Advertisement> ads2) {
        /*check in ads1 which ads occur most times and half of this occurs swap with
         the most valuable ads from ads2 avoid get over limit*/

        return null;
    }

    private double calculateProfit(List<Advertisement> ads) {
        double profit = 0;
        for(Advertisement ad : ads) {
            profit += ad.getProfit();
        }

        return profit;
    }
}
