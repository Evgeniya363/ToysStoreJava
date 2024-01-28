package org.example.service;

import org.example.model.Toy;
import org.example.model.ToysList;
import org.example.service.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrizeDrow {
    public static ToysList execute(PriorityQueue<Toy> queue) {

        ToysList prizes = new ToysList();
        for (int i = 0; i < Config.getPrizesNumber(); i++) {
           Toy toy = queue.poll();
           toy.decreaseWeight();
           prizes.add(toy);
        }
        return prizes;
    }
}
