package com.company.model;

import java.util.LinkedList;
import java.util.List;

public class Pizza {

    private int pizzaid;
    private String pName;
    private int price;
    private List<ingredients> pIngredients;


    public static final class Builder {

        private int pizzaid;
        private String pName;
        private int price;
        private final List<ingredients> pIngredients = new LinkedList<>();

        public Builder pizzaid(int pizzaid){

            this.pizzaid = pizzaid;
            return this;
        }

        public Builder pName(String pName){

            this.pName = pName;
            return this;
        }

        public Builder price(int price){

            this.price = price;
            return this;
        }

        public Builder pIngredients(ingredients pIngredient){

            this.pIngredients.add(pIngredient);
            return this;
        }


        public Pizza build(){

            if(pName.isEmpty()){
                throw new IllegalStateException("pName can not be empty!");
            }

            Pizza pizza = new Pizza();
            pizza.pizzaid = this.pizzaid;
            pizza.pName = this.pName;
            pizza.price = this.price;
            pizza.pIngredients = this.pIngredients;

            return pizza;
        }

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaid=" + pizzaid +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                ", pIngredients=" + pIngredients +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public int getPizzaid() {
        return pizzaid;
    }

    public String getpName() {
        return pName;
    }

    public List<ingredients> getpIngredients() {
        return pIngredients;
    }

}
