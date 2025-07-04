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
        try (Stream<String> lines = Files.lines(Path.of("expense-tracker/src/Transactions.txt"))) {
            return lines.map((s) -> {
                String[] items = s.split(" ");
                String name = items[0];
                Person p = new Person(name);

                String[] friends = items[6].split(",");
                Float amt = Float.parseFloat(items[2]) / friends.length;
                for (String friend : friends) {
                    friend = friend.trim();
                    if (!friend.equals(name)) {
                        p.addExpense(new Expense(friend, amt));
                    }
                }
                return p;
            }).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printTransactions(List<Person> personList) {
        LOG.info("List of transactions -");

        for (Person p : personList) {

            p.getExpenseList().forEach((e) -> {
                String txn = e.getPaidTo() + " pays " + p.getName() + " " + e.getAmt();
                LOG.info(txn);
            });
        }
    }
}