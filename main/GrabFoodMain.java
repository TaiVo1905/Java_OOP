
import java.util.ArrayList;

import model.Address;
import model.FoodItem;
import model.Customer;
// import model.FoodItem;
import model.Order;
import model.OrderDetail;
import model.Restaurant;
import io.CustomerFile;
import io.RestaurantFile;
import io.OrderFile;
import java.util.Scanner;

public class GrabFoodMain {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        ArrayList<Order> orders = new ArrayList<Order>();
        customers = CustomerFile.OutputFile("D:\\OOP_Project\\file.txt\\customer.txt");
        restaurants = RestaurantFile.OutputFile("D:\\OOP_Project\\file.txt\\restaurant.txt");
        orders = OrderFile.OutputFile("D:\\OOP_Project\\file.txt\\order.txt");
        while (true) {
            printMenu();
            System.out.print("Your choice: ");
            int input = in.nextInt();
            in.nextLine();
            switch (input) {
                case 1:
                    outer:
                        while (true) {
                            printRestaurantMenu();
                            System.out.print("Your choice: ");
                            input = in.nextInt();
                            in.nextLine();
                            switch (input) {
                                case 1:
                                    restaurants = createRestaurant(restaurants);
                                    break;
                                case 2:
                                    restaurants = addFood(restaurants);
                                    break;
                                case 3:
                                    restaurants = deleteFood(restaurants);
                                    break;
                                case 4:
                                    viewRestaurent(restaurants);
                                    break;
                                case 5:
                                    viewFood(restaurants);
                                    break;
                                case 6:
                                    restaurants = deleteRestaurant(restaurants);
                                    break;
                                case 7:
                                    System.out.println("7. Back to main program\n");
                                    break outer;
                                default:
                                    System.out.println("Your choice invalid.");
                                    break;
                        }
                    }
                    break;
                case 2:
                    outer:
                        while (true) {
                            printCustomerMenu();
                            System.out.print("Your choice: ");
                            input = in.nextInt();
                            in.nextLine();
                            switch (input) {
                                case 1:
                                    customers = createCustomer(customers);
                                    break;
                                case 2:
                                    viewCustomer(customers);
                                    break;
                                case 3:
                                    customers = deleteCustomer(customers);
                                    break;
                                case 4:
                                    customers = updateCustomer(customers);
                                    break;
                                case 5:
                                    System.out.println("Back to main program.\n");
                                    break outer;
                                default:
                                    System.out.print("Your choice invalid.");
                                    break;
                            }
                        }
                        break;
                case 3:
                    outer:
                        while (true) {
                            printOrdermenu();
                            System.out.print("Your choice: ");
                            input = in.nextInt();
                            in.nextLine();
                            switch (input) {
                                case 1:
                                    orders = orderFood(customers, restaurants, orders);
                                    break;
                                case 2:
                                    viewOrder(orders);
                                    break;
                                case 3:
                                    System.out.println("Back to main program.\n");
                                    break outer;
                                default:
                                    System.out.print("Your choice invalid.");
                                    break;
                            }
                        }
                        break;
                case 4:
                        System.out.println("End program.");
                        System.out.println("See you later.");
                        CustomerFile.InputFile(customers, "D:\\OOP_Project\\file.txt\\customer.txt");
                        RestaurantFile.InputFile(restaurants, "D:\\OOP_Project\\file.txt\\restaurant.txt");
                        OrderFile.InputFile(orders,"D:\\OOP_Project\\file.txt\\order.txt");
                        return;
                default:
                    System.out.println("Your choice invalid.\n\n");
                    break;
            }
        }   
    }
    
    //main menu
    private static void printMenu(){
        System.out.println("==========Menu==========");
        System.out.println("1. Management Restaurant");
        System.out.println("2. Management Customer");
        System.out.println("3. Order");
        System.out.println("4. Exit the program");
    }


    //restaurant menu
    private static void printRestaurantMenu() {
        System.out.println("\n\n==========Restaurant Menu==========");
        System.out.println("1. Create restaurant");
        System.out.println("2. Add food to the restaurant");
        System.out.println("3. Delete food from the restaurant");
        System.out.println("4. View restaurant");
        System.out.println("5. View food from the restaurant");
        System.out.println("6. Delete restaurant");
        System.out.println("7. Back to main program");
    }

    //Create restaurant
    private static ArrayList<Restaurant> createRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.println("\n\n==========Create restaurant==========");
        System.out.print("Enter restaurant's id: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.print("Enter restaurant's name: ");
        String restaurantName = in.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = in.nextLine();
        System.out.print("Enter restaurant's province: ");
        String provinceName = in.nextLine();
        System.out.print("Enter restaurant's district: ");
        String districtName = in.nextLine();
        System.out.print("Enter restaurant's commune: ");
        String communeName = in.nextLine();
        System.out.print("Enter restaurant's locality: ");
        String localityName = in.nextLine();
        System.out.print("Enter restaurant website: ");
        String website = in.nextLine();
        System.out.print("Enter restaurant category: ");
        String restaurantCategory = in.nextLine();
        Restaurant restaurant = null;
        if(restaurants.isEmpty() == true){
            restaurant = new Restaurant(id, restaurantName,
            new Address(id, localityName, communeName, districtName, provinceName), website, phoneNumber, restaurantCategory);
            System.out.println("Create restaurant successfully.\n");
        }else{
            for(Restaurant res : restaurants){
                if(res.getId() == id){
                    System.out.println("Id already exist.");
                    System.out.println("Back to restaurant menu.");
                    return restaurants;
                }else if(res.getPhoneNumber().equals(phoneNumber)){
                    System.out.println("Phone numbe already exitst.");
                    System.out.println("Back to restaurant menu.");
                    return restaurants;
                } else if(res.getWebsite().equals(website)){
                    System.out.println("Website already exitst.");
                    System.out.println("Back to restaurant menu.");
                    return restaurants;
                } else if(res.equals(restaurants.getLast())){
                    restaurant = new Restaurant(id, restaurantName,
                    new Address(id, localityName, communeName, districtName, provinceName), website, phoneNumber, restaurantCategory);
                    System.out.println("Create restaurant successfully.\n");
                }
            }
        }
        System.out.print("Would you like to add food to the restaurant now? (Enter \"OK\" to confirm)\nYour choice: ");
        String answer = in.nextLine();
        answer = answer.toUpperCase();
        switch (answer) {
            case "OK":
                outer:
                    while (true) {
                        System.out.print("Enter food's name: ");
                        String foodName = in.nextLine();
                        System.out.print("Enter food's unit price: ");
                        double unitPrice = in.nextDouble();
                        in.nextLine();
                        System.out.print("Enter food category: ");
                        String foodCategory = in.nextLine();
                        if(restaurant.getFoodItem().isEmpty()){
                            restaurant.addFoodItem(new FoodItem(restaurant.getFoodItem().size()+1, foodName, unitPrice, foodCategory));
                            System.out.println("Add food successfully.\n");
                        }else{
                            for(FoodItem foodItem : restaurant.getFoodItem()){
                                if(foodItem.getEntityName().equals(foodName)){
                                    System.out.println("The food's name already exitst.");
                                    break;
                                } else if(foodItem.equals(restaurant.getFoodItem().getLast())){
                                    restaurant.addFoodItem(new FoodItem(restaurant.getFoodItem().size()+1, foodName, unitPrice, foodCategory));
                                    System.out.println("Add food successfully.\n");
                                }
                            }
                        }
                        System.out.print("Do you want to continue adding food? (Enter \"OK\" to confirm)\nYour choice: ");
                        answer = in.nextLine();
                        answer = answer.toUpperCase();
                        if(answer.equals("OK")){
                            continue outer;
                        } else{
                            restaurants.add(restaurant);
                            System.out.println("Back to restaurant menu.\n\n");
                            break outer;
                        }
                    }
                break;
        
            default:
                restaurants.add(restaurant);
                System.out.println("Back to restaurant menu.\n\n");
                break;
        }
        return restaurants;       
    }

    //Add food
    private static ArrayList<Restaurant> addFood(ArrayList<Restaurant> restaurants) {
        if(restaurants.isEmpty() == true){
            System.out.println("There are no restaurants. Need creating restarants.");
            System.out.println("Back to restaurant menu.\n\n");
            return restaurants;
        }
        System.out.println("\n\n==========Add food==========");
        System.out.println("No." + "\t\t" + "Restaurant name");
        for(Restaurant res : restaurants){
            System.out.println(res.getId() + "\t\t" + res.getEntityName());
        }
        System.out.print("Your choice: ");
        int input = in.nextInt();
        in.nextLine();
        for(Restaurant res : restaurants){
            if(input == res.getId()){
                outer:
                    while (true) {
                        System.out.print("Enter food's name: ");
                        String foodName = in.nextLine();
                        System.out.print("Enter food's unit price: ");
                        double unitPrice = in.nextDouble();
                        in.nextLine();
                        System.out.print("Enter food category: ");
                        String foodCategory = in.nextLine();
                        if(res.getFoodItem().isEmpty() == true){
                            res.addFoodItem(new FoodItem(res.getFoodItem().size()+1, foodName, unitPrice, foodCategory));
                            System.out.println("Add food successfully.\n");
                        }else{
                            for(FoodItem foodItem : res.getFoodItem()){
                                if(foodItem.getEntityName().equals(foodName)){
                                    System.out.println("The food's name already exitst.");
                                    break;
                                } else if(foodItem.equals(res.getFoodItem().getLast())){
                                    res.addFoodItem(new FoodItem(res.getFoodItem().size()+1, foodName, unitPrice, foodCategory));
                                    System.out.println("Add food successfully.\n");
                                }
                            }
                        }
                        System.out.print("Do you want to continue adding food? (Enter \"OK\" to confirm)\nYour choice: ");
                        String answer = in.nextLine();
                        answer = answer.toUpperCase();
                        if(answer.equals("OK")){
                            continue outer;
                        } else{
                            break outer;
                        }
                    }
            break;
            } else if(res.equals(restaurants.getLast())){
                System.out.println("Your choice invalid.");
                System.out.println("Back to restaurant menu.\n\n");
            }
        }
        return restaurants;
    }
 
    //delete food
    private static ArrayList<Restaurant> deleteFood(ArrayList<Restaurant> restaurants) {
        if(restaurants.isEmpty() == true){
            System.out.println("There are no restaurants. Need creating restarants.");
            System.out.println("Back to restaurant menu.\n\n");
            return restaurants;
        }
        System.out.println("\n\n==========Delete food==========");
        System.out.println("No." + "\t\t" + "Restaurant name");
        for(Restaurant res : restaurants){
            System.out.println(res.getId() + "\t\t" + res.getEntityName());
        }
        System.out.print("Your choice: ");
        int input = in.nextInt();
        in.nextLine();
        for(Restaurant res : restaurants){
            if(input == res.getId()){
                outer:
                    while (true) {
                        if(res.getFoodItem().isEmpty() == true){
                            System.out.println("There are no food in this restaurant.\n");
                        }
                        else{
                            System.out.print("No." + "\t\t" + "Food name");
                            for(FoodItem foodItem:res.getFoodItem()){
                                System.out.print(foodItem.getId() + "\t\t" + foodItem.getEntityName());
                            }
                            System.out.print("Your choice: ");
                            input = in.nextInt();
                            in.nextLine();
                            for(FoodItem foodItem : res.getFoodItem()){
                                if(input == foodItem.getId()){
                                    res.getFoodItem().remove(foodItem);
                                    System.out.println("Delete food successfully.\n");
                                    break;
                                } else if(foodItem.equals(res.getFoodItem().getLast())){
                                    System.out.println("Your choice invalid.");
                                }
                            }
                        }
                        System.out.print("Do you want to continue deleting food? (Enter \"OK\" to confirm)\nYour choice: ");
                        String answer = in.nextLine();
                        answer = answer.toUpperCase();
                        if(answer.equals("OK")){
                            continue outer;
                        } else{
                            restaurants.add(res);
                            System.out.println("Back to restaurant menu.");
                            break outer;
                        }
                    }
                break;
            } else if(res.equals(restaurants.getLast())){
                System.out.println("Your choice invalid.");
                System.out.println("Back to restaurant menu.");
            }
        }
        return restaurants;
    }

    //View restaurant
    private static void viewRestaurent(ArrayList<Restaurant> restaurants) {
        if(restaurants.isEmpty() == true){
            System.out.println("There are no restaurants. Need creating restarants.");
            System.out.println("Back to restaurant menu.");
            return;
        }
        System.out.println("\n\n==========View restaurant==========");
        for(Restaurant res : restaurants){
            System.out.println(res.toString());
        }
        System.out.print("Enter any to exit.\nAnswer: ");
        String answer = in.nextLine();
        System.out.println("Back to restaurant menu.");
    }

    //View food from restaurant
    private static void viewFood(ArrayList<Restaurant> restaurants) {
        if(restaurants.isEmpty() == true){
            System.out.println("There are no restaurants.");
            System.out.println("Back to restaurant menu.\n\n");
            return;
        }
        System.out.println("\n\n==========Restaurant's food==========");
        System.out.println("No." + "\t\t" + "Restaurant name");
        for(Restaurant res : restaurants){
            System.out.println(res.getId() + "\t\t" + res.getEntityName());
        }
        System.out.print("Your choice: ");
        int input = in.nextInt();
        in.nextLine();
        for(Restaurant res : restaurants){
            if(input == res.getId()){
                if(res.getFoodItem().isEmpty() == true){
                    System.out.println("There are no food in this restaurant.\n");
                    System.out.println("Back to restaurant menu.");
                    return;
                }
                System.out.println("No." + "\t\t" + "Food name" + "\t\t" + "Unit price" + "\t\t" + "Category");
                for(FoodItem foodItem:res.getFoodItem()){
                    System.out.println(foodItem.getId() + "\t\t" + foodItem.getEntityName() + "\t\t" + foodItem.getUnitPrice() +"\t\t"+foodItem.getFoodCategory());
                }
                break;
            }
        }
        System.out.print("Enter any to exit.\nAnswer: ");
        String answer = in.nextLine();
        System.out.println("Back to restaurant menu.");
    }

    //Delete Restaurant
    private static ArrayList<Restaurant> deleteRestaurant(ArrayList<Restaurant> restaurants) {
        outer:
            while (true) {
                if(restaurants.isEmpty() == true){
                    System.out.println("There are no restaurants. Need creating restarants.");
                    System.out.println("Back to restaurant menu.\n\n");
                    return restaurants;
                }
                System.out.println("\n\n==========Delete restaurant==========");
                System.out.println("No." + "\t\t" + "Restaurant name");
                for(Restaurant res : restaurants){
                    System.out.println(res.getId() + "\t\t" + res.getEntityName());
                }
                System.out.print("Your choice: ");
                int input = in.nextInt();
                in.nextLine();
                for(Restaurant res : restaurants){
                    if(input == res.getId()){
                        restaurants.remove(res);
                        System.out.println("Delete restaurant successfully.\n");
                        System.out.print("Do you want to continue deleting restaurant? (Enter \"OK\" to confirm)\nYour choice: ");
                            String answer = in.nextLine();
                            answer = answer.toUpperCase();
                            if(answer.equals("OK")){
                                continue outer;
                            } else{
                                break outer;
                            }
                    }else if(res.equals(restaurants.getLast())){
                        System.out.println("Your choice invalid.");
                        System.out.println("Back to restaurant menu.");
                        break outer;
                    }
                } 
            }
            
        return restaurants;
    }


    //Customer menu
    private static void printCustomerMenu() {
        System.out.println("\n\n==========Customer Menu==========");
        System.out.println("1. Create customer");
        System.out.println("2. View customer");
        System.out.println("3. Delete customer");
        System.out.println("4. Update customer");
        System.out.println("5. Back to main program");
    }

    //Create customer
    private static ArrayList<Customer> createCustomer(ArrayList<Customer> customers) {
        outer:
            while(true){
                System.out.println("\n\n==========Create customer==========");
                System.out.println("1. Create customer with full information");
                System.out.println("2. Create customer with customer's name");
                System.out.println("3. Back to customer menu");
                System.out.print("Your choice: ");
                int input = in.nextInt();
                in.nextLine();
                int id;
                String customerName;
                String phoneNumber;
                String email;
                String provinceName;
                String districtName;
                String communeName;
                String localityName;
                switch (input) {
                    case 1:
                        System.out.print("Enter customer's id: ");
                        id = in.nextInt();
                        in.nextLine();
                        System.out.print("Enter customer's name: ");
                        customerName = in.nextLine();
                        System.out.print("Enter customer's phone number: ");
                        phoneNumber = in.nextLine();
                        System.out.print("Enter customer's email: ");
                        email = in.nextLine();
                        System.out.print("Enter customer's province: ");
                        provinceName = in.nextLine();
                        System.out.print("Enter customer's district: ");
                        districtName = in.nextLine();
                        System.out.print("Enter customer's commune: ");
                        communeName = in.nextLine();
                        System.out.print("Enter customer's locality: ");
                        localityName = in.nextLine();
                        if(customers.isEmpty() == true){
                            customers.add(new Customer(id, customerName, email, phoneNumber,
                            new Address(id, localityName, communeName, districtName, provinceName)));
                        }else{
                            for(Customer cus : customers){
                                if(cus.getId() == id){
                                    System.out.println("Id already exitst.");
                                    System.out.println("Back to customer menu.\n\n");
                                    break;
                                }else if(cus.getPhoneNumber().equals(phoneNumber)){
                                    System.out.println("Phone numbe already exitst.");
                                    System.out.println("Back to create customer.\n\n");
                                    continue outer;
                                } else if(cus.getEmail().equals(email)){
                                    System.out.println("Email already exitst.");
                                    System.out.println("Back to create customer.\n\n");
                                    continue outer;
                                } else if(cus.equals(customers.getLast())){
                                    customers.add(new Customer(id, customerName, email, phoneNumber,
                                    new Address(id, localityName, communeName, districtName, provinceName)));
                                    System.out.println("create customer successfully.\n");
                                }
                            }
                        }
                        System.out.print("Do you want to continue create customer(Enter \"OK\" to confirm)\nYour choice: ");
                        String answer = in.nextLine();
                        answer = answer.toUpperCase();
                        if(answer.equals("OK")){
                            continue outer;
                        } else{
                            break outer;
                        }
                    case 2:
                        System.out.print("Enter customer's id: ");
                        id = in.nextInt();
                        in.nextLine();
                        System.out.print("Enter customer's name: ");
                        customerName = in.nextLine();
                        if(customers.isEmpty() == true){
                            customers.add(new Customer(id, customerName));
                            System.out.println("create customer successfully.\n");
                        }else{
                            for(Customer cus : customers){
                                if(cus.getId() == id){
                                    System.out.println("Id already exitst.");
                                    System.out.println("Back to create customer.\n\n");
                                    continue outer;
                                }else if(cus.equals(customers.getLast())){
                                    customers.add(new Customer(id, customerName));
                                    System.out.println("create customer successfully.\n");
                                }
                            }
                        }
                        System.out.print("Do you want to continue create customer(Enter \"OK\" to confirm)\nYour choice: ");
                        answer = in.nextLine();
                        answer = answer.toUpperCase();
                        if(answer.equals("OK")){
                            continue outer;
                        } else{
                            break outer;
                        }
                    case 3:
                        System.out.println("Back to customer menu.");
                        break outer;
                    default:
                        System.out.println("Your choice invalid.");
                        break;
                }
            }
        return customers;
    }

    //View customer
    private static void viewCustomer(ArrayList<Customer> customers) {
        if(customers.isEmpty() == true){
            System.out.println("There are no customers. Need creating customers.");
            System.out.println("Back to customer menu.");
            return;
        }
        System.out.println("\n\n==========View customer==========");
        System.out.println("No." + "\t\t" + "Name" + "\t\t" + "Email" + "\t\t" + "Phone number" + "\t\t" + "Address");
        for(Customer cus : customers){
            System.out.println(cus.toString());
        }
        System.out.print("Enter any to exit.\nAnswer: ");
        String answer = in.nextLine();
        System.out.println("Back to customer menu.");
    }

    //Delete customer
    private static ArrayList<Customer> deleteCustomer(ArrayList<Customer> customers) {
        outer:
            while (true) {
                if(customers.isEmpty() == true){
                    System.out.println("There are no customers.");
                    System.out.println("Back to customer menu.");
                    return customers;
                }
                System.out.println("\n\n==========Delete customer==========");
                System.out.println("No." + "\t\t" + "Customer name");
                for(Customer cus : customers){
                    System.out.println(cus.getId() + "\t\t" + cus.getEntityName());
                }
                System.out.print("Enter customer's id: ");
                int input = in.nextInt();
                in.nextLine();
                for(Customer cus : customers){
                    if(input==cus.getId()){
                        customers.remove(cus);
                        System.out.println("Delete customer successfully.\n");
                        System.out.print("Do you want to continue deleting customer? (Enter \"OK\" to confirm)\nYour choice: ");
                            String answer = in.nextLine();
                            answer = answer.toUpperCase();
                            if(answer.equals("OK")){
                                continue outer;
                            } else{
                                System.out.println("Back to customer menu.");
                                break outer;
                            }
                    }else if(cus.equals(customers.getLast())){
                        System.out.println("Your choice invalid.");
                        System.out.println("Back to customer menu.");
                        break outer;
                    }
                } 
            }
        return customers;
    }

    //Update customer
    private static ArrayList<Customer> updateCustomer(ArrayList<Customer> customers) {
        if(customers.isEmpty() == true){
            System.out.println("There are no customers.");
            System.out.println("Back to customer menu.");
            return customers;
        }
        System.out.println("\n\n==========Update customer==========");
        outer:
            while (true) {
                System.out.println("No." + "\t\t" + "Customer name" + "\t\t" + "Phone number");
                for(Customer cus : customers){
                    System.out.println(cus.getId() + "\t\t" + cus.getEntityName() + "\t\t" + cus.getPhoneNumber());
                }
                System.out.print("Enter customer's id: ");
                int input = in.nextInt();
                in.nextLine();
                for(Customer cus : customers){
                    if(input == cus.getId()){
                        System.out.println("Select function:");
                        System.out.println("1. Update email");
                        System.out.println("2. Update phone number");
                        System.out.println("3. Update address");
                        System.out.println("4. Back to customer menu");
                        System.out.print("Your choice: ");
                        input = in.nextInt();
                        in.nextLine();
                        switch (input) {
                            case 1:
                                System.out.print("Enter customer's email: ");
                                String email = in.nextLine();
                                cus.setEmail(email);
                                System.out.println("Update email successfully.\n");
                                break;
                            case 2:
                                System.out.print("Enter customer's phone number: ");
                                String phoneNumber = in.nextLine();
                                cus.setPhoneNumber(phoneNumber);
                                System.out.println("Update phone number successfully.\n");
                                break;
                            case 3:
                                System.out.print("Enter customer's province: ");
                                String provinceName = in.nextLine();
                                System.out.print("Enter customer's district: ");
                                String districtName = in.nextLine();
                                System.out.print("Enter customer's commune: ");
                                String communeName = in.nextLine();
                                System.out.print("Enter customer's locality: ");
                                String localityName = in.nextLine();
                                cus.setAddress(new Address(cus.getId(), localityName, communeName, districtName, provinceName));
                                System.out.println("Update address successfully.\n");
                                break;
                            case 4:
                                System.out.println("Back to customer menu.");
                                break outer;
                            default:
                                System.out.println("Your choice invalid.\n");
                                break;
                        }
                        System.out.print("Do you want to continue updating customer? (Enter \"OK\" to confirm)\nYour choice: ");
                            String answer = in.nextLine();
                            answer = answer.toUpperCase();
                            if(answer.equals("OK")){
                                continue outer;
                            } else{
                                break outer;
                            }
                    }else if(cus.equals(customers.getLast())){
                        System.out.println("Your choice invalid.");
                        System.out.println("Back to customer menu.");
                        break outer;
                    }
                } 
            }
        return customers;
    }


    //Order menu
    private static void printOrdermenu() {
        System.out.println("\n\n==========Order menu==========");
        System.out.println("1. Order food");
        System.out.println("2. View order");
        System.out.println("3. Back to main program");
    }

    //Order food
    private static ArrayList<Order> orderFood(ArrayList<Customer> customers, ArrayList<Restaurant> restaurants, ArrayList<Order> orders) {
        if(restaurants.isEmpty() == true){
            System.out.println("There are no restaurants.");
            System.out.println("Back to order menu.\n\n");
            return orders;
        }else if(customers.isEmpty() == true){
            System.out.println("There are no customers.");
            System.out.println("Back to order menu.\n\n");
            return orders;
        }
        System.out.println("\n\n==========Order food==========");
        System.out.print("Enter customer's phone number: ");
        String answer = in.nextLine();
        for(Customer cus : customers){
            if(answer.equals(cus.getPhoneNumber())){
                System.out.println("\n\n==========View restaurant==========");
                System.out.println("No." + "\t\t" + "Restaurant name");
                for(Restaurant res : restaurants){
                    System.out.println(res.getId() + "\t\t" + res.getEntityName());
                    System.out.println("Select restaurant you want to order food.");
                    System.out.print("Your choice: ");
                    int input = in.nextInt();
                    in.nextLine();
                    ArrayList<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
                    if(res.getFoodItem().isEmpty() == true){
                        System.out.println("This restaurant does not have the food item.");
                        System.out.println("Back to order menu.");
                        return orders;
                    }
                    if(input == res.getId()){
                        System.out.println("No." + "\t\t" + "Food name" + "\t\t" + "Unit price" + "\t\t" + "Category");
                        for(FoodItem foodItem:res.getFoodItem()){
                            System.out.println(foodItem.getId() + "\t\t" + foodItem.getEntityName() + "\t\t" + foodItem.getUnitPrice() +"\t\t"+foodItem.getFoodCategory());
                        }
                        while(true){
                            System.out.print("Select food you want to order: ");
                            input = in.nextInt();
                            in.nextLine();
                            System.out.print("Enter quantity: ");
                            int quantity = in.nextInt();
                            in.nextLine();
                            for(FoodItem foodItem:res.getFoodItem()){
                                if(input == foodItem.getId()){
                                    orderDetail.add(new OrderDetail(foodItem, foodItem.getUnitPrice(), quantity));
                                    break;
                                }
                                else if(foodItem.equals(res.getFoodItem().getLast())){
                                    System.out.println("Order dissuccesfully. Your choice is not in our seris food.");
                                }
                            }
                            System.out.print("Do you want to choose other food?(Enter \"OK\" to confirm)\nYour choice: ");
                            answer = in.nextLine();
                            answer = answer.toUpperCase();
                            if(answer.equals("OK")){
                                continue;
                            } else{
                                orders.add(new Order(cus, orderDetail, res));
                                System.out.println("Order ssuccessfully.\nBack to order menu.\n");
                                break;
                            }
                        }
                    }
                        break;
                    }
                break;
            }else if(cus.equals(customers.getLast())){
                System.out.println("Your phone number does not exist.");
                System.out.println("Back to order menu.\n");
            }
        }
        return orders;
    }

    //View order
    private static void viewOrder(ArrayList<Order> orders) {
        if(orders.isEmpty() == true){
            System.out.println("There are no orders.");
            System.out.println("Back to customer menu.");
            return;
        }
        outer:
            while (true) {
                System.out.println("\n\n==========View order==========");
                System.out.println("1. Customer's view order");
                System.out.println("2. Restaurant's view order");
                System.out.println("3. Back to order menu");
                System.out.print("Your choice: ");
                int input = in.nextInt();
                in.nextLine();
                boolean bug = true;
                switch (input) {
                    case 1:
                        System.out.print("Enter customer's phone number: ");
                        String phoneNumber = in.nextLine();
                        for(Order or : orders){
                            if(or.getCustomer().getPhoneNumber().equals(phoneNumber)){
                                if(or.equals(orders.getFirst())){
                                    System.out.println("Customer name"+"\t\t"+"Date"+"\t\t"+"Restaurant name"+"\t\t"+"Total price");
                                }
                                System.out.println(or.toString());
                                bug = false;
                            }else if(bug = true && or.equals(orders.getLast())){
                                System.out.println("Phone number does not exist.");
                                System.out.println("Back to view order.\n\n");
                                break outer;
                            }
                        }
                        System.out.print("Enter any to exit.\nAnswer: ");
                        String answer = in.nextLine();
                        System.out.println("Back to view order.");
                        break;
                    case 2:
                        System.out.print("Enter restaurant's phone number: ");
                        phoneNumber = in.nextLine();
                        for(Order or : orders){
                            if(or.getRestaurant().getPhoneNumber().equals(phoneNumber)){
                                if(or.equals(orders.getFirst())){
                                    System.out.println("Customer name"+"\t\t"+"Date"+"\t\t"+"Restaurant name"+"\t\t"+"Total price");
                                }
                                System.out.println(or.toString());
                                bug = false;
                            }else if(bug = true && or.equals(orders.getLast())){
                                System.out.println("Phone number does not exist.");
                                System.out.println("Back to view order.");
                                break outer;
                            }
                        }
                        System.out.print("Enter any to exit.\nAnswer: ");
                        answer = in.nextLine();
                        System.out.println("Back to view order.");
                        break;
                    case 3:
                        System.out.println("Back to order menu.");
                        break outer;
                    default:
                        System.out.println("Your choice invalid.");
                        break;
                }
            }
        
    }
}
