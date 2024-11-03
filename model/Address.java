package model;

import java.io.Serializable;

public class Address extends EntityName  implements Serializable{
    //instance variables
    private String commune;
    private String district;
    private String province;

    //constructors
    public Address (int id, String locality, String commune, String district, String province){
        super(id, locality);
        this.commune = commune;
        this.district = district;
        this.province = province;
    }
    
    //getter/setter
    public String getCommune(){
        return commune;
    }
    public void setCommune(String commune){
        this.commune = commune;
    }
    public String getDistrict(){
        return district;
    }
    public void setDistrict(String district){
        this.district = district;
    }
    public String getProvince(){
        return province;
    }
    public void setProvince(String province){
        this.province = province;
    }

    //toString
    @Override
    public String toString(){
        return super.toString() + "\t\t" + commune + "\t\t" + district + "\t\t" + province;
    }
}