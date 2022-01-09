package com.company.model;

import java.util.LinkedList;
import java.util.List;

public class Order {

    private int orderid;
    private int pizzaid;
    private int userid;
    private List<String> additionalsIngredients;
    private List<String> subtractsIngredients;

    public static final class Builder {

        private int orderid;
        private int pizzaid;
        private int userid;
        private List<String> additionalsIngredients = new LinkedList<>();
        private List<String> subtractsIngredients = new LinkedList<>();

        public Builder pizzaid(int pizzaid) {
            this.pizzaid = pizzaid;
            return this;
        }

        public Builder orderid(int orderid){

            this.orderid = orderid;
            return this;
        }

        public Builder userid(int userid){

            this.userid = userid;
            return this;
        }

        public Builder subtractsIngredients(String subtractsIngredients){

            this.subtractsIngredients.add(subtractsIngredients);
            return this;
        }

        public Builder additionalsIngredients(String additionalsIngredients){

            this.additionalsIngredients.add(additionalsIngredients);
            return this;
        }

        public Order build(){


            Order order = new Order();
            order.orderid = this.orderid;
            order.pizzaid = this.pizzaid;
            order.userid = this.userid;
            order.additionalsIngredients = this.additionalsIngredients;
            order.subtractsIngredients = this.subtractsIngredients;

            return order;

        }

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", pizzaid=" + pizzaid +
                ", userid=" + userid +
                ", additionalsIngredients=" + additionalsIngredients +
                ", subtractsIngredients=" + subtractsIngredients +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public int getPizzaid() {
        return pizzaid;
    }

    public int getUserid() {
        return userid;
    }

    public List<String> getAdditionalsIngredients() {
        return additionalsIngredients;
    }

    public List<String> getSubtractsIngredients() {
        return subtractsIngredients;
    }
}
