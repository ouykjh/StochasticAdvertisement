/**
 * Created by kuba on 2015-05-02.
 */
public class Advertisement {

    private int limit;
    private int amount = 0;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
