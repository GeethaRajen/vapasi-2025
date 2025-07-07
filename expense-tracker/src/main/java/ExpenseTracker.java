import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ExpenseTracker {

    public static final Logger LOG = Logger.getLogger(ExpenseTracker.class.getName());
    public static final int FRIENDS_INDEX = 6;
    public static final int AMOUNT_INDEX = 2;

    public static void main(String[] args) {
        ExpenseTracker demo = new ExpenseTracker();
        String path = "expense-tracker/src/main/resources/transactions.txt";
        Collection<Person> personCollection = demo.readExpensesFromFile(path);
        demo.printTransactions(personCollection);
    }

    public Collection<Person> readExpensesFromFile(String path) {
        LOG.info("Reading expenses from file and creating objects");
        try (Stream<String> expenseLines = Files.lines(Path.of(path)))
        {
            List<String> expenseList = expenseLines.toList();
            HashMap<String, Person> personMap = new HashMap<>();
            for(String transaction:expenseList){
                convertToPerson(transaction, personMap);
            }
            return personMap.values();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void convertToPerson(String transaction, HashMap<String, Person> personMap) {
        String[] expenseItems = transaction.split(" ");
        String name = expenseItems[0];
        Person person;
        if (personMap.get(name) == null) {
            person = new Person(name);
            personMap.put(name, person);
        } else {
            person = personMap.get(name);
        }
        int noOfFriends = expenseItems.length - FRIENDS_INDEX;
        Float amtSpentForEach = Float.parseFloat(expenseItems[AMOUNT_INDEX]) / noOfFriends;

        for (int i = 0; i < noOfFriends; i++) {
            String friend = expenseItems[i + FRIENDS_INDEX].split(",")[0];
            if (!friend.equals(name)) {
                person.addExpense(friend, amtSpentForEach);
            }
        }
    }

    public void printTransactions(Collection<Person> collection) {
        LOG.info("List of transactions");
        for (Person person : collection) {
            LOG.info(person.getConsolidatedExpense());
        }
    }
}