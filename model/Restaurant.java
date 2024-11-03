package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant extends EntityName  implements Serializable{
    //instance variable
    private Address address;
    private String website;
    private String phoneNumber;
    private String restaurantCategory;
    private ArrayList<FoodItem> foodItems;
    
    //constructor
    public Restaurant(int id, String restaurantName, Address address, String website, String phoneNumber, String restaurantCategory){
        super(id, restaurantName);
        try{
            if(!checkPhoneNumber(phoneNumber)){
                throw new Exception("Phone number isn't correct format (correctly format: 0123456789).");
            }
            else{
                this.address = address;
                this.website = website;
                this.phoneNumber = phoneNumber;
                this.restaurantCategory = restaurantCategory;
                this.foodItems = new ArrayList<FoodItem>();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Restaurant(int id, String restaurantName, Address address, String website, String phoneNumber, String restaurantCategory, ArrayList<FoodItem> foodItems){
        super(id, restaurantName);
        try{
            if(!checkPhoneNumber(phoneNumber)){
                throw new Exception("Phone number isn't correct format (correctly format: 0123456789).");
            }
            else{
                this.address = address;
                this.website = website;
                this.phoneNumber = phoneNumber;
                this.restaurantCategory = restaurantCategory;
                this.foodItems = foodItems;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //getter/setter
    public Address getAddress(){
        return address;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    public String getWebsite(){
        return website;
    }
    public void setWebsite(String website){
        this.website = website;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        try{
            if(!checkPhoneNumber(phoneNumber)){
                throw new Exception("Phone number isn't in correct format (correctly format: 0123456789).");
            }
            else{
                this.phoneNumber = phoneNumber;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String getRestaurantCategory(){
        return restaurantCategory;
    }
    public void setRestaurantCategory(String restaurantCategory){
        this.restaurantCategory = restaurantCategory;
    }
    public ArrayList<FoodItem> getFoodItem(){
        return foodItems;
    }

    //method
    public void addFoodItem(FoodItem foodItem){
        this.foodItems.add(foodItem);
    }
    public void removeFoodItem(FoodItem foodItem){
        this.foodItems.remove(foodItem);
    }

    //toString
    @Override
    public String toString(){
        return "No. "+ getId() + "\nRestaurant name: " + getEntityName() + "\nAddress: "
        + address.getEntityName() + ", " + address.getCommune() + ", " + address.getDistrict() + ", " + address.getProvince() + "\nWebsite: "
        + website + "\nPhone number: " + phoneNumber +"\nCategory: " + restaurantCategory + "\n";
    }

    //Check phone number
    private boolean checkPhoneNumber(String phoneNumber){
        try{
            Integer.parseInt(phoneNumber);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
