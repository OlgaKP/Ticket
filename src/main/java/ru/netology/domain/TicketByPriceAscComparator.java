package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TicketByPriceAscComparator implements Comparator<Ticket> {
    private int id;
    private int price;
    private String fromAir;
    private String toAir;
    private int time;

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTime() - o2.getTime();
    }
}
