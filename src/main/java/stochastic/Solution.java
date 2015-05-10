package stochastic;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maciejprokopiuk
 * Date: 10/05/15
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class Solution {


    private List<Advertisement> advertisements;
    private final Double profit;

    public Solution(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
        profit = calculateProfit();
    }

    private Double calculateProfit() {

        return advertisements.stream().mapToDouble(
            ad -> {
                if (ad.getNumberOfImpressionsLeft() > 0) {
                    return ad.getProfit();
                } else {
                    return -ad.getProfit() * Config.getPunishment();
                }
            }
        ).sum();
    }

    public Double getProfit() {
        return profit;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }
}
