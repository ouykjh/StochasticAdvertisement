package stochastic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kuba on 2015-05-02.
 */
public class Algorithm {

    private List<Advertisement> ads;
    private int iterations;
    private Map<Double, Solution> solutions;
    private CrossoverStrategy strategy;
    private int numberOfAdsInSet;

    private TreeMap<Double, Solution> cachedSolutions;


    public Algorithm(List<Advertisement> ads, int iterations, int numberOfAdsInSet, CrossoverStrategy strategy) {
        this.ads = ads;
        this.iterations = iterations;
        this.solutions = new TreeMap<Double, Solution>();
        this.cachedSolutions = new TreeMap<>();
        this.strategy = strategy;
        this.numberOfAdsInSet = numberOfAdsInSet;
    }

    public Solution getBestSolutionForUser() {
        Solution solution = cachedSolutions.pollFirstEntry().getValue();

        //TODO move it to some cached class
        Solution newSolution = getBestSolution();

        cachedSolutions.put(newSolution.getProfit(), newSolution);

        return solution;
    }

    /* generate random solutions and crossover them (generation and crossover should be separate)*/
    public Solution getBestSolution() {


        for (int i = 0; i < iterations; i++) {

            Solution firstSolution = generateSolution();
            Solution secondSolution = generateSolution();
            Solution child = strategy.crossover(firstSolution, secondSolution);

            solutions.put(firstSolution.getProfit(), firstSolution);
            solutions.put(secondSolution.getProfit(), secondSolution);
            solutions.put(child.getProfit(), child);

            solutions = solutions.entrySet()
                .stream()
                .limit(Config.getNumberOfCachedSolutions())
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        }

        return new TreeMap<>(solutions).pollFirstEntry().getValue();
    }


    /*generate list of random solutions, profit is calculating with over-limit punishment*/
    public Solution generateSolution() {

        List<Advertisement> ads = new ArrayList<>();
        for (int i = 0; i < numberOfAdsInSet; i++) {
            ads.add(randomAd());
        }

        return new Solution(ads);
    }

    private Advertisement randomAd() {
        Random r = new Random();
        return ads.get(r.nextInt((ads.size() - 1)));
    }

}
