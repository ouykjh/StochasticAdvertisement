import org.junit.Test;
import stochastic.*;
import stochastic.crossovers.DiverseCrossover;
import stochastic.crossovers.ProfitableCrossover;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kuba on 2015-05-12.
 */
public class CrossoverTest {

    private static final int iterations = 1000;
    private static final int numberOfAdsInSet = 10;

    private DataGenerator dataGenerator = new DataGenerator();
    private List<Advertisement> ads;
    private Algorithm algorithm;

    @Test
    public void diverseCrossoverTest() {
        CrossoverStrategy diverseCrossover = new DiverseCrossover();

        try {
            ads = readDataFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        showProfits(diverseCrossover);
    }

    @Test
    public void profitableCrossoverTest() {
        CrossoverStrategy profitableCrossover = new ProfitableCrossover();

        try {
            ads = readDataFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        showProfits(profitableCrossover);
    }

    private void showProfits(CrossoverStrategy crossover) {
        for(int i = 0; i<100; i++) {
            algorithm = new Algorithm(ads, iterations, numberOfAdsInSet, crossover);
            Solution solution = algorithm.getBestSolution();

            System.out.println(solution.getProfit());
        }
    }

    private List<Advertisement> readDataFromFile() throws FileNotFoundException {
        List<Advertisement> ads = new ArrayList<>();
        FileReader fileReader = new FileReader(Config.getFileName());
        Scanner s = new Scanner(fileReader);

        while(s.hasNext()) {
            ads.add(new Advertisement(Integer.parseInt(s.next()), Double.parseDouble(s.next())));
        }
        return ads;
    }

    @Test
    public void generateDataToFile() {
        try {
            dataGenerator.saveDataToFile(500);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
