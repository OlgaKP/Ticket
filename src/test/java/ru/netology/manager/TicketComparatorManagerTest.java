package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketByPriceAscComparatorManagerTest {
    private TicketComparatorManager manager = new TicketComparatorManager();
    private Ticket tik1 = new Ticket(1, 1000, "MSK", "BLG", 39);
    private Ticket tik2 = new Ticket(2, 1200, "MSK", "BLG", 30);
    private Ticket tik5 = new Ticket(5, 1100, "MSK", "BLG", 35);
    private Ticket tik3 = new Ticket(3, 1500, "IZH", "LND", 78);
    private Ticket tik4 = new Ticket(4, 1700, "IZH", "LND", 70);
    private Ticket tik6 = new Ticket(6, 1800, "IZH", "LND", 75);
    private Ticket tik7 = new Ticket(7, 1000, "IZH", "LND", 70);

    @BeforeEach
    public void setUp() {
        manager.add(tik1);
        manager.add(tik2);
        manager.add(tik3);
        manager.add(tik4);
        manager.add(tik5);
        manager.add(tik6);
    }

    @Test
    public void shouldSortByPrice() {
        Ticket[] actual = manager.findAllFromTo("MSK", "BLG", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{tik2, tik5, tik1};

        Arrays.sort(actual, new TicketByPriceAscComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceWithDifferentFromTo() {
        Ticket[] actual = manager.findAllFromTo("MSK", "LND", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{};

        Arrays.sort(actual, new TicketByPriceAscComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceWithEqualPrice() {
        manager.add(tik7);
        Ticket[] actual = manager.findAllFromTo("IZH", "LND", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{tik4, tik7, tik6, tik3};

        Arrays.sort(actual, new TicketByPriceAscComparator());
        assertArrayEquals(expected, actual);
    }
}