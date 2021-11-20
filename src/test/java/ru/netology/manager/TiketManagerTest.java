package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TiketManagerTest {
    private TicketManager manager = new TicketManager();
    private Ticket tik1 = new Ticket(1, 1000, "MSK", "BLG", 39);
    private Ticket tik2 = new Ticket(2, 1200, "MSK", "BLG", 30);
    private Ticket tik5 = new Ticket(5, 1100, "MSK", "BLG", 35);
    private Ticket tik3 = new Ticket(3, 1500, "IZH", "LND", 78);
    private Ticket tik4 = new Ticket(4, 1700, "IZH", "LND", 70);
    private Ticket tik6 = new Ticket(6, 1800, "IZH", "LND", 75);
    private Ticket tik7 = new Ticket(7, 1800, "IZH", "LND", 74);

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
        Ticket[] actual = manager.findAllFromTo("MSK", "BLG");
        Ticket[] expected = new Ticket[]{tik1, tik5, tik2};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceWithDifferentFromTo() {
        Ticket[] actual = manager.findAllFromTo("MSK", "LND");
        Ticket[] expected = new Ticket[]{};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceWithEqualPrice() {
        manager.add(tik7);
        Ticket[] actual = manager.findAllFromTo("IZH", "LND");
        Ticket[] expected = new Ticket[]{tik3, tik4, tik6, tik7};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}