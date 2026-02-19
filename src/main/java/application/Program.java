package application;

import model.entities.Department;
import model.entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Department obj = new Department(1, "Books");

        System.out.println(obj);

        Date date = null;

        try{
            date = sdf.parse(sc.nextLine());
        } catch(ParseException e){
            System.out.println("Error: " + e.getMessage());
        }


        Seller seller = new Seller(3000.00, date , obj, "bob@gmail.com", 21, "Bob");

        System.out.println(seller);
    }
}
