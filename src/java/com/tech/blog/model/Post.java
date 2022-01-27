/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.model;

/**
 *
 * @author MeGa
 */
public class Post {
    private Integer pId;
    private String pTitle;
    private String pContent;
    private String pCode;
    private String pPic;
    private Integer catId;

    public Post() {
    }

    public Post(Integer pId, String pTitle, String pContent, String pCode, String pPic, Integer catId) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.catId = catId;
    }

    public Post(String pTitle, String pContent, String pCode, String pPic, Integer catId) {
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.catId = catId;
    }
    
}
