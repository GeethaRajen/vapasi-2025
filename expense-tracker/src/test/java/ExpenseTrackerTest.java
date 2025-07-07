import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

class ExpenseTrackerTest {

    private static ExpenseTracker tracker;
    private Person person;
    private String path;

    @BeforeAll
    public static void init(){
        tracker = new ExpenseTracker();
    }

    @BeforeEach
    public void initEach(){
        person = new Person("A");
        person.addExpense("B",50f);
        path = "src/test/java/transactions1.txt";
    }

    @Test
    void shouldReturnOneMatchingProductFromFile() {
        Collection<Person> personSet = tracker.readExpensesFromFile(path);
        assertEquals(1, personSet.size());
        assertEquals(personSet.toArray()[0].toString(),person.toString());
    }

    @Test
    void shouldReturnFiveProductsFromFile() {
        String path = "src/test/java/transactions2.txt";
        Collection<Person> personSet = tracker.readExpensesFromFile(path);
        assertEquals(5, personSet.size());
    }

    @Test
    void shouldNotHaveExpenseRecordForSpenderHimself(){
        Collection<Person> personSet = tracker.readExpensesFromFile(path);
        Person p = (Person)personSet.toArray()[0];
        String paidTo = (String)p.getExpenseMap().keySet().toArray()[0];
        assertNotEquals(person.getName(),paidTo);
    }
}