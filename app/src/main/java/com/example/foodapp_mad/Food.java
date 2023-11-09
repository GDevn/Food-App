package com.example.foodapp_mad;
 //This holds the attributes of each food which is exists inside the restaurant
public class Food {
    public int id;
    public String name;
    public double price;
    public String restaurant;


    public Food(int idP, String nameP, double priceP, String restaurantP){
        this.id = idP;
        this.name = nameP;
        this.price = priceP;
        this.restaurant = restaurantP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
