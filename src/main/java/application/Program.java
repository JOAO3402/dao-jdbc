package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(1);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj: list){
            System.out.println(obj);
        }

        Department department = new Department(1, "Book");

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(4000.0, new Date(), department, "greg@gmailcom", null, "Greg");
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        newSeller = sellerDao.findById(10);
        newSeller.setName("Terence Mann");
        newSeller.setEmail("mann@gmail.com");
        sellerDao.update(newSeller);

        newSeller = sellerDao.findById(11);
        newSeller.setName("Carmen Robinson");
        newSeller.setEmail("carmen@gmail.com");
        sellerDao.update(newSeller);

        newSeller = sellerDao.findById(12);
        newSeller.setName("Cadwell Pope");
        newSeller.setEmail("cadwell@gmail.com");
        sellerDao.update(newSeller);

        newSeller = sellerDao.findById(9);
        newSeller.setName("Bledsoe Scotthurdy");
        newSeller.setEmail("scott@gmail.com");
        sellerDao.update(newSeller);
        System.out.println("Update Complete");
    }
}
