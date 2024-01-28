package org.example.service;

import org.example.model.PrizesList;
import org.example.model.Toy;
import org.example.model.ToysList;
import org.example.service.config.Config;
import org.example.service.exception.IllegalArraySizeException;
import org.example.service.exception.NullArrayException;
import org.example.service.exception.ParseImpossibleException;

import java.util.*;

public class PrizeFundCreator {

    public static PrizesList toysCreate(String[] strings) throws ParseImpossibleException {
        PrizesList toys = new PrizesList();
        if (strings == null) {
            throw new NullArrayException();
        } else if (strings.length < 3) {
            throw new IllegalArraySizeException(strings.length, Config.getSizeArray());
        } else {
            for (String str : strings) {
                List<String> fieldList = new ArrayList<String>(Arrays
                        .asList(str.split(",")));
                Toy toy = Builder.CreateToy(fieldList);
                toys.add(toy);
//                System.out.println(toy);
            }
        }
        return toys;
    }

    public static PriorityQueue<Toy> toysQueueCreate(ToysList toys) throws ParseImpossibleException {
        PriorityQueue<Toy> queue = new PriorityQueue<>();
        for(Toy toy: toys) {
            int quantity = (new Random()).nextInt(toy.getStartWeight() - 1, 100);
            for (int i = 0; i < quantity; i++) {
                queue.add(toy);
            }
            queue.add(toy);
            toy.changeQuantity(quantity);
        }
        return queue;
    }
}
