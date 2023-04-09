import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    private Ticket ticket1 = new Ticket("MSK", "SPB", 10, 0, 1);
    private Ticket ticket2 = new Ticket("MSK", "NEW", 20, 23, 6);
    private Ticket ticket3 = new Ticket("MSK", "LA", 100, 11, 13);
    private Ticket ticket4 = new Ticket("MSK", "SPB", 140, 1, 3);
    private Ticket ticket5 = new Ticket("MSK", "SPB", 150, 2, 5);
    private Ticket ticket6 = new Ticket("MSK", "SPB", 100, 7, 9);

    @Test
    public void shouldSearchIfNotFind() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchAndSort("MSK", "NVG");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPrice() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = new Ticket[]{ticket1, ticket6, ticket4, ticket5};
        Ticket[] actual = manager.searchAndSort("MSK", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = new Ticket[]{ticket1, ticket4, ticket5};
        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldCompareIfSamePrice() {
        AviaSouls manager = new AviaSouls();

        int expected = 0;
        int actual = ticket6.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }
}