/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import com.tech.blog.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MeGa
 */
public class PostDao {
    Connection connection;

    public PostDao(Connection connection) {
        this.connection = connection;
    }
    
    public ArrayList<Category> getAllCategory()
    {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String query = " SELECT * FROM categories";
            Statement st = connection.createStatement();
            ResultSet set = st.executeQuery(query);
            while (set.next()) {                
                Integer cId = set.getInt("cid");
                String name = set.getString("name");
                String description = set.getString("description");
                Category c = new Category(cId, name, description);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }
}
