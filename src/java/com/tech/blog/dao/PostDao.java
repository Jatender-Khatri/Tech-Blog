/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import com.tech.blog.model.Category;
import com.tech.blog.model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MeGa
 */
public class PostDao {

    Connection connection;

    public PostDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Category> getAllCategory() {
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

    public boolean savePost(Post p) {
        boolean f = false;
        try {
            String query = "insert into posts(pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, p.getpTitle());
            ps.setString(2, p.getpContent());
            ps.setString(3, p.getpCode());
            ps.setString(4, p.getpPic());
            ps.setInt(5, p.getCatId());
            ps.setInt(6, p.getUserId());
            ps.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return f;
    }

//    get all posts
    public List<Post> getAllPosts() {
        List<Post> list = new ArrayList<>();
        // fetch all the posts
        try {
            PreparedStatement ps = connection.prepareStatement("select * from posts order by pid desc");
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Integer pId = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Integer cId = set.getInt("catId");
                Integer uId = set.getInt("userId");

                Post p = new Post(pId, pTitle, pContent, pCode, pPic, cId, uId);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }

    // get posts by category
    public List<Post> getPostByCatId(Integer catId) {
        List<Post> list = new ArrayList<>();
        // fetch all post by category
        try {
            PreparedStatement ps = connection.prepareStatement("select * from posts where catId = ?");
            ps.setInt(1, catId);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Integer pId = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Integer uId = set.getInt("userId");
                Post p = new Post(pId, pTitle, pContent, pCode, pPic, catId, uId);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }

    public Post getPostByPostId(Integer postId) {
        Post post = null;
        try {
            String query = "select * from posts where pid=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, postId);

            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Integer pId = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Integer uId = set.getInt("userId");
                Integer catId = set.getInt("catId");
                post = new Post(pId, pTitle, pContent, pCode, pPic, catId, uId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return post;
    }
    
    
}
