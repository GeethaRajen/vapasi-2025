public class Expense {
    private final String paidTo;
    private final Float amt;

    public Expense(String paidTo, Float amt) {
        this.paidTo = paidTo;
        this.amt = amt;
    }

    public String getPaidTo() {
        return paidTo;
    }

    public Float getAmt() {
        return amt;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "paidTo='" + paidTo + '\'' +
                ", amt=" + amt +
                '}';
    }
}
