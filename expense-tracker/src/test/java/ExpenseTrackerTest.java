import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ExpenseTrackerTest {

    private static ExpenseTracker tracker;

    @BeforeAll
    public static void init(){
        tracker = new ExpenseTracker();
    }

    @Test
    void shouldReturnOneMatchingProductFromFile() {
        String path = "src/test/java/transactions1.txt";

        List<Person> list = tracker.readExpensesFromFile(path);
        assertEquals(1, list.size());

        Person p = new Person("A");
        Expense e = new Expense("B",50f);
        p.addExpense(e);
        assertEquals(list.getFirst().toString(),p.toString());
    }

    @Test
    void shouldReturnSixProductsFromFile() {
        String path = "src/test/java/transactions2.txt";

        List<Person> list = tracker.readExpensesFromFile(path);
        assertEquals(6, list.size());
    }

    @Test
    void shouldNotHaveExpenseRecordForSpenderHimself(){
        String path = "src/test/java/transactions1.txt";

        List<Person> list = tracker.readExpensesFromFile(path);
        assertEquals(1, list.size());

        Person p = new Person("A");
        Expense e = new Expense("B",50f);
        p.addExpense(e);
        assertNotEquals("A",list.getFirst().getExpenseList().getFirst().paidTo());
    }
}