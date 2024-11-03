package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Restaurant;

public class RestaurantFile {
    public static boolean InputFile(ArrayList<Restaurant> arrayList, String fileName){
        try{
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static ArrayList<Restaurant> OutputFile(String fileName){
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            restaurants = (ArrayList<Restaurant>) data;
            ois.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return restaurants;
    }
}
