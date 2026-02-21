package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Scanner sc = new Scanner(System.in);

        System.out.println("==== TEST 6: seller delete ====");
        System.out.println("Enter id for delete test: ");
        int id = Integer.parseInt(sc.nextLine());
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
    }
}
