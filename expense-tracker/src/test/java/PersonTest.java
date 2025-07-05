import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class PersonTest {

    private static Person p;

    @BeforeAll
    public static void init(){
        p = new Person("A");
        p.addExpense(new Expense("B",50f));
    }

    @Test
    void getConsolidatedExpense() {
        String expected = "B pays " + p.getName() + " " + p.getExpenseList().getFirst().amt() + System.lineSeparator();
        Assertions.assertEquals(expected, p.getConsolidatedExpense());
    }
}