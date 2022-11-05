package kz.kenzhakhimov.javaEE;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/market", "postgres", "postgre");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String email) {
        User user = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from users where email = ?");
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCity(resultSet.getString("city"));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static boolean addUser(User user) {
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into users(email,password,city) values(?,?,?)");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getCity());
            rows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }

    public static boolean addBlog(Blog blog) {
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into blogs(user_id,title,content,picture_url,post_date)" +
                    "values(?,?,?,?,NOW())");
            stmt.setLong(1, blog.getUser().getId());
            stmt.setString(2, blog.getTitle());
            stmt.setString(3, blog.getContent());
            stmt.setString(4, blog.getPicture_url());
            rows = stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }

    public static ArrayList<Blog> getAllBlogs() {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.title, b.content, b.picture_url, b.post_date, b.user_id, u.email, u.city FROM blogs b join users u on b.user_id = u.id order by b.post_date desc" +
                    "");
            ResultSet resultSet = statement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setEmail(resultSet.getString("email"));
                user.setCity(resultSet.getString("city"));
                blogs.add(new Blog(
                        resultSet.getLong("id"),
                        user,
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("picture_url"),
                        resultSet.getTimestamp("post_date")
                ));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
    }

    public static Blog getBlog(Long id) {
        Blog blog = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.title, b.content, b.post_date, b.picture_url, b.user_id, u.email, u.city " +
                    "FROM blogs b " +
                    "JOIN users u ON u.id = b.user_id WHERE b.id = ?" +
                    "");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setCity(resultSet.getString("city"));

                blog = new Blog();
                blog.setId(resultSet.getLong("id"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPost_date(resultSet.getTimestamp("post_date"));
                blog.setPicture_url(resultSet.getString("picture_url"));
                blog.setUser(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blog;
    }

    public static boolean addComment(Comment comment) {
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments(user_id, blog_id, comment, post_date)" +
                    "VALUES (?, ?, ?, NOW())" +
                    "");
            statement.setLong(1, comment.getUser().getId());
            statement.setLong(2, comment.getBlog().getId());
            statement.setString(3, comment.getComment());
            rows = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static ArrayList<Comment> getAllComments(Long id){
        ArrayList<Comment> comments = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT c.id, c.user_id, c.blog_id, c.comment, c.post_date, u.email, u.city FROM comments c JOIN users u ON c.user_id = u.id WHERE c.blog_id = ? ORDER BY c.post_date DESC" +
                    "");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Blog blog = new Blog();
            User user = new User();
            while (resultSet.next()){
                blog.setId(resultSet.getLong("blog_id"));
                user.setId(resultSet.getLong("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setCity(resultSet.getString("city"));
                comments.add(new Comment(
                        resultSet.getLong("id"),
                        user,
                        blog,
                        resultSet.getString("comment"),
                        resultSet.getTimestamp("post_date")
                ));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public static Admin getAdmin (String email){
        Admin admin = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from admins where email = ?");
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin;
    }

    public static boolean deleteUser(String email){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM users WHERE email = ?" +
                    "");
            statement.setString(1, email);
            rows = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean updateUser(User user){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET password = ?, city = ? " +
                    "WHERE email = ?" +
                    "");
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getCity());
            statement.setString(3, user.getEmail());
            rows = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows > 0;
    }
}
