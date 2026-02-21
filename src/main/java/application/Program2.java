package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        Scanner sc = new Scanner(System.in);

        System.out.println("FindById department test");
        Department fDepp = departmentDao.findById(1);
        System.out.println(fDepp);

        System.out.println("FindAll Department TEST");
        List<Department> list = departmentDao.findAll();
        for(Department d: list){
            System.out.println(d);
        }

        System.out.println("Insert department TEST");
        Department dep = new Department(8, "Food");
        departmentDao.insert(dep);
        System.out.println(dep);
    }
}
