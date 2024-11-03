package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Customer;

public class CustomerFile {
    public static boolean InputFile(ArrayList<Customer> arrayList, String fileName){
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
    public static ArrayList<Customer> OutputFile(String fileName){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            customers = (ArrayList<Customer>) data;
            ois.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return customers;
    }
}
