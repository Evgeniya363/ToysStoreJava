package org.example.model;

import java.util.PriorityQueue;

public class PrizeFundQueue extends PriorityQueue<Toy>{
    private static PriorityQueue<Toy> toys = new PriorityQueue<>();

    public Toy decreasePoll() {
        Toy toy = this.poll();
        if (toy != null) toy.decreaseWeight();
        return toy;
    }
}
