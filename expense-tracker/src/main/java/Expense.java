public record Expense(String paidTo, Float amt) {

    @Override
    public String toString() {
        return "Expense{" +
                "paidTo='" + paidTo + '\'' +
                ", amt=" + amt +
                '}';
    }
}
