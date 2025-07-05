import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ExpenseTracker {

    public static final Logger LOG = Logger.getLogger(ExpenseTracker.class.getName());

    public static void main(String[] args) {
        ExpenseTracker demo = new ExpenseTracker();
        List<Person> personList = demo.readExpensesFromFile();
        demo.printTransactions(personList);
    }

    public List<Person> readExpensesFromFile() {
        LOG.info("Reading expenses from file and creating objects");
        try (Stream<String> expenseLines = Files.lines(Path.of("expense-tracker/src/transactions.txt"))) {
            return expenseLines.map((s) -> {
                String[] expenseItems = s.split(" ");
                String name = expenseItems[0];
                Person person = new Person(name);

                String[] spentForFriends = expenseItems[6].split(",");
                Float amtSpentForEach = Float.parseFloat(expenseItems[2]) / spentForFriends.length;
                for (String friend : spentForFriends) {
                    friend = friend.trim();
                    if (!friend.equals(name)) {
                        person.addExpense(new Expense(friend, amtSpentForEach));
                    }
                }
                return person;
            }).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printTransactions(List<Person> personList) {
        LOG.info("List of transactions -");

        for (Person person : personList) {
            LOG.info(person.getConsolidatedExpense());
        }
    }
}