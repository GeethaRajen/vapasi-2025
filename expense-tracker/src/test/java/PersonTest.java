import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class PersonTest {

    private static Person p;

    @BeforeAll
    public static void init(){
        p = new Person("A");
        p.addExpense("B",50f);
    }

    @Test
    void shouldReturnExpectedConsolidatedExpenseStatement() {
        String expected = "B pays " + p.getName() + " " + p.getExpenseMap().values().toArray()[0] + System.lineSeparator();
        Assertions.assertEquals(expected, p.getConsolidatedExpense());
    }
}