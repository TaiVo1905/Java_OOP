package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements Serializable{
    Customer customer;
    LocalDate date;
    ArrayList<OrderDetail> orderDetails;
    Restaurant restaurant;
    double totalPrice;

    //Constructors
    public Order(Customer customer, LocalDate date, ArrayList<OrderDetail> orderDetails, Restaurant restaurant){
        this.customer = customer;
        this.date = date;
        this.orderDetails = orderDetails;
        this.restaurant = restaurant;
        for(OrderDetail orderDetail:orderDetails){
            this.totalPrice += orderDetail.getUnitPrice() * orderDetail.getQuantity();
        }
    }
    public Order(Customer customer, ArrayList<OrderDetail> orderDetails, Restaurant restaurant){
        this.customer = customer;
        this.date = LocalDate.now();
        this.orderDetails = orderDetails;
        this.restaurant = restaurant;
        for(OrderDetail orderDetail:orderDetails){
            this.totalPrice += orderDetail.getUnitPrice() * orderDetail.getQuantity();
        }
    }

    //getter
    public Customer getCustomer(){
        return customer;
    }
    public LocalDate getDate() {
        return date;
    }
    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }

    //toString
    @Override
    public String toString() {
        return getCustomer().getEntityName() + "\t\t" + date + "\t\t" + getRestaurant().getEntityName() + "\t\t" + totalPrice;
    }
}
