package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        Scanner sc = new Scanner(System.in);

        System.out.println("==== TEST 7: department delete ====");
        System.out.println("Enter id for delete test: ");
        Department dep = new Department(3, "Fashion");
        Department dep1 = new Department(2, "Eletronics");
        departmentDao.deleteById(dep, dep1);
        System.out.println("Delete completed");
    }
}
