package model.dao;

import model.dao.impl.SellerDaoJDBC;
import model.exceptions.DB;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
