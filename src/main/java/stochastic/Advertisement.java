package stochastic;

/**
 * Created by kuba on 2015-05-02.
 */
public class Advertisement {

    private int limit;
    private int numberOfImpressions = 0;
    private double profit;


    public Advertisement(int limit, double profit) {
        this.limit = limit;
        this.profit = profit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getNumberOfImpressions() {
        return numberOfImpressions;
    }

    public void increaseImpressionsCount() {
        numberOfImpressions++;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public int getNumberOfImpressionsLeft() {
        return limit - numberOfImpressions;
    }

    public double getValue() {

        return numberOfImpressions / limit;
    }
}
