package model;

import java.io.Serializable;

public class FoodItem extends EntityName implements Serializable{
    //instance variable
    private double unitPrice;
    private String foodCategory;

    //constructor
    public FoodItem(int id, String foodItemName, double unitPrice, String foodCategory){
        super(id, foodItemName);
        try{
            if(unitPrice < 0){
                throw new Exception("Unit price must be greater than 0.");
            }
            else{
                this.unitPrice = unitPrice;
                this.foodCategory = foodCategory;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //getter/setter
    public double getUnitPrice(){
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    public String getFoodCategory(){
        return foodCategory;
    }
    public void setFoodCategory(String foodCategory){
        this.foodCategory = foodCategory;
    }

    //toString
    @Override
    public String toString(){
        return super.toString() + "\t\t" + unitPrice + "\t\t" + foodCategory;
    }
}
