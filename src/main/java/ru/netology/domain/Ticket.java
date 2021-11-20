package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String fromAir;
    private String toAir;
    private int time;

    @Override
    public int compareTo(Ticket p) {
        return this.price - p.price;
    }
}

