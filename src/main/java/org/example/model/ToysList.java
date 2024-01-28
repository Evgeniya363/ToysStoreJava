package org.example.model;

import java.util.ArrayList;

public class ToysList extends ArrayList<Toy> {



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(Toy toy: this) {
            sb.append("    ")
                .append(i++)
                .append(". ")
                .append(toy.getShortInfo())
                .append("\n");
        };
        return sb.toString();
    }
}
