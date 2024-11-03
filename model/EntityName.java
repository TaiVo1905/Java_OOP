package model;

import java.io.Serializable;

public abstract class EntityName implements Serializable {
    //Instance variables
    private int id;
    private String entityName;

    //Constructor
    public EntityName(){

    }
    public EntityName(int id, String entityName){
        try{
            if(id < 0){
                throw new Exception("Id must be greater than 0.");
            }
            else{
                this.id = id;
                this.entityName = entityName;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Getter/setter
    public int getId(){
        return id;
    }
    public String getEntityName(){
        return entityName;
    }
    public void setEntityName(String entityName){
        this.entityName = entityName;
    }

    //toString
    @Override
    public String toString(){
        return id + "\t\t" + entityName;
    }
}
