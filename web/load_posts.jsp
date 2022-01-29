<%@page import="com.tech.blog.model.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<div class="row">
    <%
       
        PostDao d = new PostDao(ConnectionProvider.getConnection());
        Integer cid = Integer.parseInt(request.getParameter("cId"));
        List<Post> posts = null;
        if (cid == 0) {
            posts = d.getAllPosts();
        } else {
            posts = d.getPostByCatId(cid);
        }
        if(posts.size()==0){
            out.println("<h3 class = 'display-3 text-center'>No posts in this Category</h3>");
        }
        for (Post p : posts) {
    %>
    <div class="col-md-6 mt-2">
        <div class="card">
            <img style="height: 150px" class="card-img-top" src="blog_pics/<%= p.getpPic()%>" alt="Card image cap">
            <div class="card-body">
                <b><%= p.getpTitle()%></b>
                <p><%= p.getpContent()%></p>
                <pre><%= p.getpCode()%></pre>
            </div>
        </div>

    </div>
    <%
        }
    %>
</div>