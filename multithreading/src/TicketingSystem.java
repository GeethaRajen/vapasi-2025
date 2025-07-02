import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TicketingSystem {

    private static final Logger LOGGER = Logger.getLogger(TicketingSystem.class.getName());
    long ticket_id = 1000010;

    synchronized public void bookTicket() {
        ticket_id++;
        try {
            LOGGER.info(Thread.currentThread().getName() + " : Booking received : " + ticket_id);
            Thread.sleep(500);
            LOGGER.info(Thread.currentThread().getName() + " : Payment processed : " + ticket_id);
            Thread.sleep(500);
            LOGGER.info(Thread.currentThread().getName() + " : Ticket confirmed : " + ticket_id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TicketingDemo {
    public static void main(String[] args) {
        TicketingSystem ts = new TicketingSystem();
        Runnable ticketJob = ts::bookTicket;

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            for(int i=1;i<=5;i++){
                executor.execute(new Thread(ticketJob));
            }
        }
    }
}

