package stochastic.crossovers;

import stochastic.Advertisement;
import stochastic.CrossoverStrategy;
import stochastic.Solution;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: maciejprokopiuk
 * Date: 10/05/15
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
public class ProfitableCrossover implements CrossoverStrategy {
    @Override
    public Solution crossover(Solution firstSet, Solution secondSet) {

        int size = firstSet.getAdvertisements().size();

        List<Advertisement> advertisements = firstSet.getAdvertisements();
        advertisements.addAll(secondSet.getAdvertisements());

        Collections.sort(advertisements, (Comparator.comparingDouble(ad -> ad.getProfit())));

        return new Solution(advertisements.stream().limit(size).collect(Collectors.toList()));
    }
}
