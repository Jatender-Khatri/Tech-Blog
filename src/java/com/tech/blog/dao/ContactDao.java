/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import com.tech.blog.model.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author MeGa
 */
public class ContactDao {

    Connection con;

    public ContactDao(Connection con) {
        this.con = con;
    }

    public boolean saveContact(Contact c) {
        boolean b = false;
        try {
            String query = "insert into contact(cName,cEmail,cNumber) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, c.getcName());
            ps.setString(2, c.getcEmail());
            ps.setString(3, c.getcContact());
            ps.executeUpdate();
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return b;
    }
}
