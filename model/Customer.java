package model;

import java.io.Serializable;

public class Customer extends EntityName  implements Serializable{
    //Instance variables
    private String email;
    private String phoneNumber;
    private Address address;
    //Constructors
    public Customer(int id, String customerName){
        super(id, customerName);
    }
    public Customer(int id, String customerName, String email, String phoneNumber, Address address){
        super(id, customerName);
        try{
            if(!email.endsWith("@gmail.com")){
                throw new Exception("Email isn't in correct format (correctly format: abc@gmail.com).");
            }
            else if(!checkPhoneNumber(phoneNumber)){
                throw new Exception("Phone number isn't in correct format (correctly format: 0123456789).");
            }
            else{
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.address = address;
            }  
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
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

    //Getter/setter
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        try{
            if(!email.endsWith("@gmail.com")){
                throw new Exception("Email isn't in correct format (correctly format: abc@gmail.com).");
            }
            else{
            this.email = email;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
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
    public Address address(){
        return address;
    }
    public void setAddress(Address address){
        this.address = address;
    }

    //toString
    @Override
    public String toString(){
        return getId() + "\t\t" + getEntityName() + "\t\t" + email + "\t\t" + phoneNumber + "\t\t"
        + address.getEntityName() + ", " + address.getCommune() + ", " + address.getDistrict() + ", " + address.getProvince();
    }
}
