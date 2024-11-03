package model;

import java.io.Serializable;

public class OrderDetail implements Serializable{
    //instance variable
    private FoodItem foodItem;
    private double unitPrice;
    private int quantity;

    //constructors
    public OrderDetail(FoodItem foodItem, double unitPrice, int quantity ){
        this.foodItem = foodItem;
        try{
            if(unitPrice < 0){
                throw new Exception("Unit price must be greater than 0.");
            }
            else if (quantity < 0){
                throw new Exception("Quantity must be greater than 0.");
            }
            else{
                this.unitPrice = unitPrice;
                this.quantity = quantity;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //getter/setter
    public FoodItem getFoodItem() {
        return foodItem;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //toString
    @Override
    public String toString() {
        return foodItem.getEntityName()+ "\t\t" + unitPrice + "\t\t" + quantity;
    }
}
