package com.company;

import com.company.model.Order;
import com.company.model.User;
import com.company.model.ingredients;
import com.company.service.OrderServiceImpl;
import com.company.service.PizzaServiceImpl;
import com.company.service.UserServiceImpl;

import java.util.*;

public class NewOrder {

    UserServiceImpl userService = new UserServiceImpl();
    PizzaServiceImpl pizzaService = new PizzaServiceImpl();
    OrderServiceImpl orderService = new OrderServiceImpl();

    int loop = 0;
    int orid = orderService.lastOrderID();

    public void newOrder() {


        int thatordid = orid;

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj swoje imię: ");
        String usname = sc.nextLine();

        System.out.println("Podaj swoj nr telefonu: ");
        int usphone = sc.nextInt();

        sc.nextLine();

        System.out.println("Podaj swoj adres email: ");
        String usEmail = sc.nextLine();

        System.out.println("Podaj adres dostawy: ");
        String usAdress = sc.nextLine();


        System.out.println(usname + " " + usphone + " " + usEmail + " " + usAdress);

        User user = new User.Builder()
                .userid(userService.lastUserID())
                .name(usname)
                .phoneNumber(usphone)
                .adressEmail(usEmail)
                .adress(usAdress)
                .build();

        Order(user,thatordid);

    }

    public void Order(User user, int thatordid){

        System.out.println("MENU: ");
        System.out.println("  PIZZA " + "       " + "PRICE" + "    " + "Ingredients" );
        pizzaService.selectAll();

        System.out.println("\nMake your order! You can find our menu above.");
        System.out.println("Choose a pizza from our menu by entering a number from 1 to 3.");

        Scanner sc = new Scanner(System.in);
        int pizzanum = sc.nextInt();

        if (pizzanum == 1){
            System.out.println("Your choose - " + pizzaService.selectName(pizzanum) + "  " + pizzaService.selectIngredients(pizzanum));
        }else
        if (pizzanum == 2){
            System.out.println("Your choose - " + pizzaService.selectName(pizzanum) + "  " + pizzaService.selectIngredients(pizzanum));
        }else
        if (pizzanum == 3){
            System.out.println("Your choose - " + pizzaService.selectName(pizzanum) + "  " + pizzaService.selectIngredients(pizzanum));
        }

        sc.nextLine();

        System.out.println("If you want to subtract a ingredient, enter its name.");
        String subtract = sc.nextLine();


        System.out.println("If you want to add a ingredients, enter their names, select from available ingredient below.");

        ingredients[] values = ingredients.values();
        for (ingredients ingredients : values) {
            System.out.println( ingredients.toString());
        }

        String additional = sc.nextLine();

        Order order = new Order.Builder()
                .orderid(thatordid)
                .pizzaid(pizzanum)
                .userid(user.getUserid())
                .additionalsIngredients(additional)
                .subtractsIngredients(subtract)
                .build();

        System.out.println("1 - Order another pizza");
        System.out.println("2 - Finish the order and go to the summary");

        int numx = sc.nextInt();

        switch (numx){
            case 1:
                // kontynuacja zamówienia
                loop++;
                orderService.NewOrder(order);
                Order(user,order.getOrderid());

                break;
            case 2:

                int finalprice = 0;

                userService.addUser(user);
                orderService.NewOrder(order);

                System.out.println(user.getName()+ " "+ user.getPhoneNumber()+ " "+ user.getAdress());
                System.out.println("\nYOUR ORDER:");

                for(int i = 0; i<=loop; i++){
                    System.out.println("Pizza: " + pizzaService.selectName(orderService.selectPizzaId(order.getOrderid()).get(i)) + " price: " +
                            pizzaService.selectPrice(orderService.selectPizzaId(order.getOrderid()).get(i)) + "   ingredients: " +
                            pizzaService.selectIngredients(orderService.selectPizzaId(order.getOrderid()).get(i)) + "\n  substract (-): " +
                            orderService.selectOrdersub(order.getOrderid()).get(i) + "        additional (+): "+
                            orderService.selectOrderadd(order.getOrderid()).get(i) );

                    finalprice = finalprice + pizzaService.selectPrice(orderService.selectPizzaId(order.getOrderid()).get(i));
                }

                System.out.println("\n TOTAL PRICE: " + finalprice);


                break;
            default:

        }
    }
}
