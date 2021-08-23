/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Category;
import Model.Product;
import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thanh Dang
 */
public class dao {
    
    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results
    public Account login(String user, String pass) {
        String querry = "Select * from Account where username = ? and password = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return null;
    }
    
    
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<>();
        String querry = "Select CategoryId ,CategoryName from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return list;
    }
    
    public ArrayList<Product> getProductByCategoryId(String id) {
        ArrayList<Product> list = new ArrayList<>();
        String querry = "select ProductId,ProductName,Price from Product where CategoryId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),1));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String querry = "Select * from Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),1));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return list;
    }
    
    public ArrayList<Product> getProductById(int id) {
        ArrayList<Product> list = new ArrayList<>();
        String querry = "Select * from Product where ProductId = " + id;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),1));
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return list;
    }
    
}
