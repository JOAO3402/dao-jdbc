package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args){

        Department obj = new Department(1, "Books");

        System.out.println(obj);

        Seller seller = new Seller(3000.00, new Date(), obj, "bob@gmail.com", 21, "Bob");

        System.out.println(seller);
    }
}
