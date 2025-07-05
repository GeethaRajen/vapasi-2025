import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final List<Expense> expenseList;

    public Person(String name) {
        this.name = name;
        this.expenseList = new ArrayList<>();
    }

    public void addExpense(Expense e) {
        expenseList.add(e);
    }

    public String getConsolidatedExpense() {
        final String[] txn = {""};
        expenseList.forEach((expense) ->
            txn[0] += expense.paidTo() + " pays " + name + " " + expense.amt() + System.lineSeparator()
        );
        return txn[0];
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", expenseList=" + expenseList +
                '}';
    }
}
