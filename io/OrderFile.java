package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Order;

public class OrderFile {
    public static boolean InputFile(ArrayList<Order> arrayList, String fileName){
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
    public static ArrayList<Order> OutputFile(String fileName){
        ArrayList<Order> orders = new ArrayList<Order>();
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            orders = (ArrayList<Order>) data;
            ois.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return orders;
    }
}
