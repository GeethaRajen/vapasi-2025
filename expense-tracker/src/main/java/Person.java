import java.util.HashMap;
import java.util.Objects;

public class Person {
    private final String name;
    private final HashMap<String, Float> expenseMap;

    public Person(String name) {
        this.name = name;
        this.expenseMap = new HashMap<>();
    }

    public void addExpense(String paidTo, Float amount) {
        amount = amount + expenseMap.getOrDefault(paidTo, 0.0f);
        expenseMap.put(paidTo, amount);
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Float> getExpenseMap() {
        return expenseMap;
    }

    public String getConsolidatedExpense() {
        final String[] txn = {""};
        expenseMap.forEach((paidTo, amount) -> txn[0] += paidTo + " pays " + name + " " + amount + System.lineSeparator());
        return txn[0];
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", expenses=" + expenseMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
