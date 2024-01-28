package org.example.model;

public class PrizesList extends ToysList{
    private static int totalWeight;
    @Override
    public boolean add(Toy toy) {
        totalWeight += toy.getStartWeight();
        return super.add(toy);
    }
    public static int getTotalWeight() {
        return totalWeight;
    }

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
