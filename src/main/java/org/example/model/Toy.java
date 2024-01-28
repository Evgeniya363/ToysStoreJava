package org.example.model;

import org.example.service.config.Config;

public class Toy implements Comparable<Toy> {
    private int id;
    private int startWeight;
    private double weight;
    private int quantity;
    private String name;

    public Toy(int id, int weight, String name) {
        this.id = id;
        this.startWeight = weight;
        this.weight = weight;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public int getStartWeight() {
        return startWeight;
    }

    public void changeQuantity(int quantity) {
        this.quantity += quantity;
    }

    public String getName() {
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getShortInfo() {
        return  "id:" + id
                + " " + name + " " + weight;

    }


    @Override
    public String toString() {
        return  "id:" + id
                + " " + name +
                ", частота выпадения: " + startWeight;

    }

    @Override
    public int compareTo(Toy o) {
        return Double.compare(o.weight, weight);
    }

    public void decreaseWeight() {
        weight -= (double) PrizesList.getTotalWeight() / Config.getPrizesNumber();
//        System.out.println("Приз "+this+" вес: "+ (double) PrizesList.getTotalWeight()+" тотал вес: "+Config.getPrizesNumber());
//        System.out.println("Вес "+ weight);
    }
}
