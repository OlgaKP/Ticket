package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

public class TicketComparatorManager {
    private TicketRepository repository = new TicketRepository();

    public TicketComparatorManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketComparatorManager() {
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAllFromTo(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] tickets = repository.findAll();
        Ticket[] result = new Ticket[0];
        int index = 0;
        for (Ticket ticket: tickets) {
            if ((ticket.getFromAir() == from) && (ticket.getToAir() == to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public Ticket[] getTickets() {
        Ticket[] tickets = repository.findAll();
        return tickets;
    }
}
