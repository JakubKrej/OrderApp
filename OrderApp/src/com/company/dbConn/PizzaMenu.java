package com.company.dbConn;

import com.company.model.Pizza;
import com.company.model.ingredients;
import com.company.service.PizzaServiceImpl;

import java.util.LinkedList;

public class PizzaMenu {

    public void PizzaMenuBuild(){

        PizzaServiceImpl piz = new PizzaServiceImpl();

        LinkedList<ingredients> margherita = new LinkedList<>();
        margherita.add(ingredients.tomatosauce);
        margherita.add(ingredients.cheese);
        margherita.add(ingredients.oregano);

        LinkedList<ingredients> capriciosa = new LinkedList<>();
        capriciosa.add(ingredients.tomatosauce);
        capriciosa.add(ingredients.cheese);
        capriciosa.add(ingredients.mushrooms);
        capriciosa.add(ingredients.salami);
        capriciosa.add(ingredients.oregano);

        LinkedList<ingredients> calzone = new LinkedList<>();
        calzone.add(ingredients.tomatosauce);
        calzone.add(ingredients.cheese);
        calzone.add(ingredients.mushrooms);
        calzone.add(ingredients.onion);
        calzone.add(ingredients.corn);
        calzone.add(ingredients.chicken);

        piz.addPizza(1, "margherita",20, margherita);
        piz.addPizza(2, "capriciosa",34, capriciosa);
        piz.addPizza(3, "calzone",40, calzone);


//        pizza = new Pizza.Builder()
//                .pizzaid(1)
//                .pName("Margherita")
//                .price(20)
//                .pIngredients(ingredients.tomatosauce)
//                .pIngredients(ingredients.cheese)
//                .pIngredients(ingredients.oregano)
//                .build();
//         pizza1 = new Pizza.Builder()
//                .pizzaid(2)
//                .pName("Capriciosa")
//                 .price(30)
//                .pIngredients(ingredients.tomatosauce)
//                .pIngredients(ingredients.cheese)
//                .pIngredients(ingredients.mushrooms)
//                .pIngredients(ingredients.salami)
//                .pIngredients(ingredients.oregano)
//                .build();
//
//        pizza2 = new Pizza.Builder()
//                .pizzaid(3)
//                .pName("Calzone")
//                .price(35)
//                .pIngredients(ingredients.tomatosauce)
//                .pIngredients(ingredients.cheese)
//                .pIngredients(ingredients.mushrooms)
//                .pIngredients(ingredients.onion)
//                .pIngredients(ingredients.corn)
//                .pIngredients(ingredients.chicken)
//                .build();
//
    }


}
