package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Department obj = new Department(1, "Books");

        System.out.println(obj);

        Seller seller = new Seller(3000.00, new Date() , obj, "bob@gmail.com", 21, "Bob");

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}
