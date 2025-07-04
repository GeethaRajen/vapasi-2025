import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final List<Expense> expenseList;

    public Person(String name) {
        this.name = name;
        this.expenseList = new ArrayList<>();
    }

    public void addExpense(Expense e){
        expenseList.add(e);
    }

    public String getName() {
        return name;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", expenseList=" + expenseList +
                '}';
    }
}
